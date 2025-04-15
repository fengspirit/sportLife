package com.sports.life.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * point类型数据测试类
 */
@Data
@AllArgsConstructor
@Builder
public class GeoPoint implements Serializable {
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;

    @Override
    public String toString() {
        //重点，这个函数会影响输出到最终的sql语句，所以中间和mysql保持一致为空格。
        return "POINT(" + longitude + " " + latitude + ")";
    }

}
