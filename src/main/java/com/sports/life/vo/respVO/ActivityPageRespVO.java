package com.sports.life.vo.respVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;


@Data
public class ActivityPageRespVO {

    @ApiModelProperty(value ="ID")
    private String id;
    @ApiModelProperty(value = "活动编号")
    private String acCode;
    @ApiModelProperty(value = "活动标题")
    private String acTitle;

    @ApiModelProperty(value = "活动封面")
    private String acUrl;
    @ApiModelProperty(value = "所属运动类型")
    private BigInteger acType;

    @ApiModelProperty(value = "活动开始时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acStartTime;

    @ApiModelProperty(value = "活动结束时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acEndTime;
    @ApiModelProperty(value = "审核状态")
    private Integer acStatus;

}
