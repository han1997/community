package com.hhy.community.community.dto;

import lombok.Data;

/**
 * @author hhy1997
 * 2020/1/19
 */
@Data
public class GithubUser {
    private String login;
    private Long id;
    private String bio;
    private String avatarUrl;

}
