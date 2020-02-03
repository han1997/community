package com.hhy.community.community.dto;

import lombok.Data;

/**
 * Create by hhy on 2020/1/19
 * @author handaxingyuner
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
