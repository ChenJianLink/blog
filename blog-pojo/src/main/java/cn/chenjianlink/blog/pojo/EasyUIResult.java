package cn.chenjianlink.blog.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * EasyUI页面显示pojo
 */
public class EasyUIResult implements Serializable {

    private Integer total;

    private List<?> rows;

    public EasyUIResult(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public EasyUIResult(long total, List<?> rows) {
        this.total = (int) total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }


}
