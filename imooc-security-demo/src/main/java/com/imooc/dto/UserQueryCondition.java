package com.imooc.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Shinelon
 */
@Getter
@Setter
public class UserQueryCondition {
    private String username;
    private int age;
    private int ageTo;

}
