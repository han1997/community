package com.hhy.community.community.model;

import lombok.Data;

/**
 * @author hhy1997
 * 2020/1/24
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;

}
