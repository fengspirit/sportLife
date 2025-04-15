package com.sports.life.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 账号/密码登录请求VO
 */
@Data
public class LoginReqVO {
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;

//    @ApiModelProperty(value = "客户端类型（1：pc,2：小程序）")
//    private String type;
}
