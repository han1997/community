package com.hhy.community.community.model;

import lombok.Data;

/**
 * @author hhy1997
 * 2020/1/21
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatar;

}
