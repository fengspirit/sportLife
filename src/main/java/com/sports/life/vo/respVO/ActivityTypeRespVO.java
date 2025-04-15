package com.sports.life.vo.respVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * 根据运动类型查询,返回的运动类型
 */
@Data
public class ActivityTypeRespVO {

    @ApiModelProperty(value = "活动ID")
    private String id;
    @ApiModelProperty(value = "活动标题")
    private String acTitle;

    @ApiModelProperty(value = "活动内容")
    private String acContent;
    @ApiModelProperty(value = "活动封面")
    private String img;
    @ApiModelProperty(value = "所属运动类型")
    private BigInteger acType;

    @ApiModelProperty(value = "活动开始时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acStartTime;

    @ApiModelProperty(value = "活动结束时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acEndTime;
}
