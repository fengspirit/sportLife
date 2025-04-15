package com.sports.life.vo.reqVO.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 订单明细表VO
 */
@Data
public class OrderDetailAddVO {


    @ApiModelProperty(value = "订单类型")
    private String orderType;

   @ApiModelProperty(value = "订单来源")
    private String orderSource;

   @ApiModelProperty(value = "活动编号")
    private String activityCode;

   @ApiModelProperty(value = "价格")
    private Integer price;

   @ApiModelProperty(value = "人数")
    private Integer numberPeople;

}
