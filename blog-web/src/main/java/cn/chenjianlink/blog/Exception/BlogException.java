package cn.chenjianlink.blog.Exception;

/**
 * 系统自定义异常
 */
public class BlogException extends Exception {
    public BlogException() {
        super();
    }

    public BlogException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
