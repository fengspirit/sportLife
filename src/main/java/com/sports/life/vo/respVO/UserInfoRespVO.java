package com.sports.life.vo.respVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录用户信息
 */
@Data
public class UserInfoRespVO {
    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "登录的用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickName;

//    @ApiModelProperty(value = "头像")
//    private String userPic;
}
