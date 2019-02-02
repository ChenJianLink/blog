package cn.chenjianlink.blog.pojo;

import java.util.List;

/**
 * 分页pojo
 */
public class Page {
    // 当前页码
    private int currentPage;
    // 总记录数
    private int totalRows;
    // 每页记录数
    private int rows;
    // 当前页的记录
    private List<?> beanList;
    //分页跳转路径
    private String url;

    /**
     * 计算总页数
     *
     * @return
     */
    public int getTotalPage() {
        int totalPage = totalRows / rows;
        return totalRows % rows == 0 ? totalPage : totalPage + 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<?> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<?> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
