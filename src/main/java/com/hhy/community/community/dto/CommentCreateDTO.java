package com.hhy.community.community.dto;

import lombok.Data;

/**
 * @author hhy1997
 * 2020/2/6
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
    private Long commentAtor;
}
