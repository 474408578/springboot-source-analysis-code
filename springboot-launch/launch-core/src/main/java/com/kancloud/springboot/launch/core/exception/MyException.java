package com.kancloud.springboot.launch.core.exception;

/**
 * 自定义 {@link Exception} 示例
 * @author xschen
 */
public final class MyException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Construct a new MyException with no other information.
     */
    public MyException() {
        super();
    }

    /**
     * Construct a new MyException for the specified message.
     * @param message Message describing this exception
     */
    public MyException(String message) {
        super(message);
    }

    /**
     * construct a new MyException for the specified throwable.
     * @param throwable throwable that caused this exception
     */
    public MyException(Throwable throwable) {
        super(throwable);
    }

    /**
     * Construct a new MyException for the specified message and throwable.
     * @param message Message describing this exception
     * @param throwable Throwable that caused this exception
     */
    public MyException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
