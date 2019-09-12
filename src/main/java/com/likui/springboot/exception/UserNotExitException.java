package com.likui.springboot.exception;

/**
 * @ClassName: UserNotExitException
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-10 17:56
 * @Version: 1.0
 */
public class UserNotExitException extends RuntimeException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public UserNotExitException() {
        super("用户不存在");
    }
}