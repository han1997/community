package com.hhy.community.community.dto;

import com.hhy.community.community.model.User;
import lombok.Data;

/**
 * @author hhy1997
 * 2020/2/8
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private String content;
    private Long commentCount;
    private Long gmtCreate;
    private Long gmtModeified;
    private Long likeCount;
    private User user;
}
