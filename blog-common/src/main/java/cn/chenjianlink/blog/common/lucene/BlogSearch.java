package cn.chenjianlink.blog.common.lucene;

import cn.chenjianlink.blog.pojo.Blog;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用lucene实现前台博客查询
 */
public class BlogSearch {

    private Directory directory = null;
    @Value("${INDEX_PATH}")
    private String INDEX_PATH;

    //获得IndexWriter对象
    private IndexWriter getIndexWriter() throws Exception {
        //创建一个indexwriter对象。
        directory = FSDirectory.open(Paths.get(INDEX_PATH, new String[0]));
        //设置分析器为IK分词器
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        return new IndexWriter(directory, config);
    }

    //添加索引
    public void addBlogIndex(Blog blog) throws Exception {
        IndexWriter indexWriter = getIndexWriter();
        Document document = new Document();
        //向document对象中添加域。
        document.add(new StringField("id", blog.getId().toString(), Field.Store.YES));
        document.add(new TextField("title", blog.getTitle(), Field.Store.YES));
        document.add(new StringField("releaseDate", DateFormatUtils.format(blog.getReleaseDate(), "yyyy-MM-dd"), Field.Store.YES));
        document.add(new TextField("content", blog.getSearchContent(), Field.Store.YES));
        //添加文档到索引库
        indexWriter.addDocument(document);
        //关闭indexwriter
        indexWriter.close();
    }

    //删除索引
    public void deleteBlogIndex(Integer blogId) throws Exception {
        IndexWriter indexWriter = getIndexWriter();
        Term term = new Term("id", blogId.toString());
        indexWriter.deleteDocuments(term);
        indexWriter.forceMergeDeletes();
        indexWriter.commit();
        indexWriter.close();
    }

    //更新索引
    public void updateBlogIndex(Blog blog) throws Exception {
        IndexWriter indexWriter = getIndexWriter();
        Document document = new Document();
        document.add(new StringField("id", blog.getId().toString(), Field.Store.YES));
        document.add(new TextField("title", blog.getTitle(), Field.Store.YES));
        document.add(new StringField("releaseDate", DateFormatUtils.format(blog.getReleaseDate(), "yyyy-MM-dd"), Field.Store.YES));
        document.add(new TextField("content", blog.getSearchContent(), Field.Store.YES));
        //更新
        indexWriter.updateDocument(new Term("id", blog.getId().toString()), document);
        indexWriter.close();
    }

    //获取IndexSearcher对象
    private IndexSearcher getIndexSearcher() throws Exception {
        //创建索引库存放的位置。
        Directory directory = FSDirectory.open(Paths.get(INDEX_PATH, new String[0]));
        //创建一个indexReader对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建一个indexsearcher对象
        return new IndexSearcher(indexReader);
    }

    //根据条件查询索引
    public List<Blog> searchBlogIndex(String query) throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();
        //创建ik分词器
        Analyzer analyzer = new IKAnalyzer();
        //设置查询条件
        QueryParser parser = new QueryParser("title", analyzer);
        Query query1 = parser.parse(query);
        QueryParser parser2 = new QueryParser("content", analyzer);
        Query query2 = parser2.parse(query);
        //查询组合
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        booleanQuery.add(query1, BooleanClause.Occur.SHOULD);
        booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
        //查询
        TopDocs topDocs = indexSearcher.search(booleanQuery.build(), 100);
        //高亮处理
        QueryScorer scorer = new QueryScorer(query1);
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
        highlighter.setTextFragmenter(fragmenter);
        List<Blog> blogList = new LinkedList<>();
        //数据处理
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document document = indexSearcher.doc(scoreDoc.doc);
            Blog blog = new Blog();
            //将数据进行封装
            blog.setId(Integer.parseInt(document.get("id")));
            blog.setReleaseDateStr(document.get("releaseDate"));
            String title = document.get("title");
            String content = document.get("content");
            //对标题高亮设置
            if (title != null) {
                TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
                String hTitle = highlighter.getBestFragment(tokenStream, title);
                if (StringUtils.isBlank(hTitle)) {
                    blog.setTitle(title);
                } else {
                    blog.setTitle(hTitle);
                }
            }
            //对内容高亮设置
            if (content != null) {
                TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(content));
                String hContent = highlighter.getBestFragment(tokenStream, content);
                if (StringUtils.isBlank(hContent)) {
                    if (content.length() <= 100) {
                        blog.setContent(content);
                    } else {
                        blog.setContent(content.substring(0, 100));
                    }
                } else {
                    if (hContent.length() <= 100) {
                        blog.setContent(hContent);
                    } else {
                        blog.setContent(hContent.substring(0, 100));
                    }
                }
            }
            blogList.add(blog);
        }
        return blogList;
    }
}
