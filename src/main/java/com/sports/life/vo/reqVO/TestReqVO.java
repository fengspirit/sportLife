package com.sports.life.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 测试数据
 *
 */
@Data
public class TestReqVO {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容描述")
    private String desc;

    @ApiModelProperty(value = "经度")
    private Double longitude;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "开始时间")
    private Date starttime;
}
