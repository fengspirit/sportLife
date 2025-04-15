package com.sports.life.service.impl;

import com.sports.life.entity.GeoPoint;
import com.sports.life.entity.Test;
import com.sports.life.mapper.TestMapper;
import com.sports.life.service.TestService;
import com.sports.life.vo.reqVO.TestReqVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    final TestMapper testMapper;
    @Override
    public String addTest(TestReqVO vo) {

        Test test = new Test();
        test.setId(UUID.randomUUID().toString());
        test.setTitle(vo.getTitle());
        test.setDesc(vo.getDesc());

        Double longitude = vo.getLongitude();
        Double latitude = vo.getLatitude();

        test.setLocation(new GeoPoint(longitude,latitude));
       // test.setStarttime(vo.getStarttime());
        test.setStarttime(new Date());

        int i = testMapper.insert(test);

        if(i!=0){
            System.out.println("新增失败");
            return "新增失败！";
        }

        return "新增成功";
    }
}
