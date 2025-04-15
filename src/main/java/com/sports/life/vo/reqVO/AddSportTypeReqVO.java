package com.sports.life.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增运动类型VO
 */
@Data
public class AddSportTypeReqVO {
    @ApiModelProperty(value = "运动名称")
    private String name;
}
