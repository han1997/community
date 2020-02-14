package com.hhy.community.community.dto;

import lombok.Data;

/**
 * @author hhy1997
 * 2020/2/13
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerId;
    private String typeName;
    private Integer type;
}
