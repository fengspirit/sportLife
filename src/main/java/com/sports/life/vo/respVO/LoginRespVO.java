package com.sports.life.vo.respVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginRespVO {
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户id")
    private String UserId;
    @ApiModelProperty(value = "用户token")
    private String accessToken;
//    @ApiModelProperty(value = "刷新token")
//    private String refreshToken;
    @ApiModelProperty(value = "昵称")
    private String nickname;
}
