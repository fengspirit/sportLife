package com.sports.life.vo.respVO;

import lombok.Data;

import java.util.Date;

/**
 * 运动类型响应VO
 */
@Data
public class SportTypePageRespVO {
    private Long id;

    private String name;

    private String createTime;

    private String createId;

    private String updateTime;

    private String updateId;

    private String deleted;
}
