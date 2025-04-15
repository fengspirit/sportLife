package com.sports.life.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 报名表请求VO
 */
@Data
public class addApplyReqVO {

    @ApiModelProperty(value = "活动分组名称")
    private String name;
    @ApiModelProperty(value = "申请人数")
    private Integer number;
    @ApiModelProperty(value = "价格/人")
    private Integer price;
    @ApiModelProperty(value = "报名截止时间")
    private Date appEndTime;
    @ApiModelProperty(value = "报名范围")
    private Integer scope;
    @ApiModelProperty(value = "定时报名")
    private Date appTime;
    @ApiModelProperty(value = "是否候补")
    private Integer standby;
    @ApiModelProperty(value = "是否限购")
    private Integer purchaseLimitation;

}
