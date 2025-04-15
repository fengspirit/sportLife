package com.sports.life.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityPageVO {
    @ApiModelProperty(value = "当前页数")
    private Integer pageNum;
    @ApiModelProperty(value = "当前页的数量")
    private Integer pageSize;
}
