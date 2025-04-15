package com.sports.life.service.impl;

import com.sports.life.entity.Apply;
import com.sports.life.mapper.ApplyMapper;
import com.sports.life.service.ApplyService;
import com.sports.life.vo.reqVO.addApplyReqVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ApplyServiceImpl implements ApplyService {

    final ApplyMapper applyMapper;

    /**
     * 批量插入报名表信息
     * （暂时这样，后期改为批量插入）
     * @param apply
     * @param activityId
     */
    @Override
    public void addApply(List<addApplyReqVO> apply, String activityId) {

        for (addApplyReqVO apply1 : apply){
            Apply apply2 = new Apply();
            BeanUtils.copyProperties(apply1,apply2);
            apply2.setAcId(activityId);
            apply2.setId(UUID.randomUUID().toString());
            apply2.setCreateTime(new Date());
            apply2.setCreateId("admin");
            apply2.setPrice(apply1.getPrice()*100);
            applyMapper.insertSelective(apply2);

        }
    }
}
