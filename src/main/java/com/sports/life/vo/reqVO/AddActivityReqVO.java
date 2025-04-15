package com.sports.life.vo.reqVO;

import com.sports.life.entity.ActivityImg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * 活动新增VO
 */
@Data
public class AddActivityReqVO {



    @ApiModelProperty(value = "图片Id")
    private String acUrl;

    @ApiModelProperty(value = "活动标题")
    private String acTitle;

    @ApiModelProperty(value = "活动轮播图")
    private List<ActivityImg> acImgs;
    @ApiModelProperty(value = "活动内容描述")
    private String acContent;
    @ApiModelProperty(value = "活动地点经度")
    private String longitude;
    @ApiModelProperty(value = "活动地点纬度")
    private String latitude;

    @ApiModelProperty(value = "活动开始时间")
    private Date acStartTime;
    @ApiModelProperty(value = "活动结束时间")
    private Date acEndTime;

    @ApiModelProperty(value = "活动类型Id",example = "0")
    private BigInteger acType;

    @ApiModelProperty(value = "活动保证方案ID")
    private String acSafe;

    @ApiModelProperty(value = "活动可见范围",example = "0")
    private Integer acScope;

    @ApiModelProperty(value = "活动问卷")
    private String acQuestionnaire;

    @ApiModelProperty(value = "申报信息表")
    private List<addApplyReqVO> acApply;

    @ApiModelProperty(value = "退款政策",example = "0")
    private Integer acRefund;

}
