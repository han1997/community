package com.hhy.community.community.dto;

import com.hhy.community.community.model.User;
import lombok.Data;

/**
 * @author hhy1997
 * 2020/1/30
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Long commentCount;
    private Long viewCount;
    private Long likeCount;
    private User user;
}
