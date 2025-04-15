package com.sports.life.vo.reqVO;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录和注册共用一个请求VO
 */
@Data
public class SysUserRegisterReqVO {

    @ApiModelProperty(value = "用户名")
    private  String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "确认密码")
    private String rePassword;
}
