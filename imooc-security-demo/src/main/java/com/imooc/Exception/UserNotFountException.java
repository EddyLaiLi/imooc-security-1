package com.imooc.Exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Shinelon
 */
@Getter
@Setter
public class UserNotFountException extends RuntimeException{

    public UserNotFountException(String id) {
        super("用户不存在");
        this.id = id;
    }

    private String id;
}
