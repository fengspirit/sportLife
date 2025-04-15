package com.sports.life.vo.respVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 轮播图接口
 */
@Data
public class BannerListRespVO {
    @ApiModelProperty(value = "图片地址")
    private String image;

    @ApiModelProperty(value = "图片描述")
    private String title;
}
