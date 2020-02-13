package com.hhy.community.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author hhy1997
 * 2020/2/11
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
