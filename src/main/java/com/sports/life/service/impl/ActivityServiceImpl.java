package com.sports.life.service.impl;

import com.github.pagehelper.PageHelper;
import com.sports.life.entity.Activity;
import com.sports.life.entity.ActivityImg;
import com.sports.life.exception.BusinessException;
import com.sports.life.exception.code.BaseResponseCode;
import com.sports.life.mapper.ActivityMapper;
import com.sports.life.service.ActivityImgService;
import com.sports.life.service.ActivityService;
import com.sports.life.service.ApplyService;
import com.sports.life.service.RedisService;
import com.sports.life.utils.CodeUtil;
import com.sports.life.utils.DataResult;
import com.sports.life.utils.PageUtil;
import com.sports.life.vo.reqVO.ActivityPageVO;
import com.sports.life.vo.reqVO.AddActivityReqVO;
import com.sports.life.vo.respVO.ActivityPageRespVO;
import com.sports.life.vo.respVO.ActivityTypeRespVO;
import com.sports.life.vo.respVO.PageVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    final RedisService  redisService;

    final ActivityMapper activityMapper;

    final ApplyService applyService;

    final ActivityImgService activityImgService;

    /**
     * 新增活动接口
     * @param vo
     * @return
     */
    @Override
    public DataResult<String> addActivity(AddActivityReqVO vo) {
        //【1】校验用户是否注册，



        //【2】生存活动ID和编码
        long codeKey = redisService.incrby("activity_code_key", 1);
        String code = CodeUtil.deptCode(String.valueOf(codeKey), 6, "0");
        String actiyityId = UUID.randomUUID().toString();
        //【3】取出经纬度
        String longitude = vo.getLongitude();
        String latitude = vo.getLatitude();
        String acAddress = longitude+','+latitude;
        //【3】将vo数据拷贝到实体内中
        Activity activity = new Activity();
        BeanUtils.copyProperties(vo,activity);

        //【4】存储报名表信息
        applyService.addApply(vo.getAcApply(),actiyityId);
        //【5】存储轮播图信息
        List<ActivityImg> acImgs = vo.getAcImgs();
        activityImgService.addImgs(acImgs,actiyityId);

        activity.setId(actiyityId);
        activity.setAcCode(code);
        activity.setAcAddress(acAddress);
        activity.setAcStatus(0);
        activity.setCreateId("admin");
        activity.setCreateTime(new Date());
        activity.setUpdateId("admin");
        activity.setUpdateTime(new Date());
        int insertSelective = activityMapper.insertSelective(activity);
        if(insertSelective!=1){
            throw  new BusinessException(BaseResponseCode.DATA_INSERT_ERR);
        }

        return DataResult.success("活动新增成功！");
    }

    /**
     * 待审核活动列表
     * @return
     */
    @Override
    public PageVO<ActivityPageRespVO> selectAllCheckActivity(ActivityPageVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());

        List<ActivityPageRespVO> list = activityMapper.checkActivity(vo);

        return PageUtil.getPageVo(list);
    }

    /**
     * 根据传入的运动类型查询所属的活动，默认查全部
     * @param acType  运动类型ID
     * @return
     */

    @Override
    public List<ActivityTypeRespVO> selectActivityType(Long acType) {

        List<Activity> activityList = activityMapper.selectBySportType(acType);
        if(CollectionUtils.isEmpty(activityList)){
            throw  new BusinessException(BaseResponseCode.SELECT_WECHAT_ERR);
        }
        ArrayList<ActivityTypeRespVO> list = new ArrayList<>();


        for (Activity acList : activityList){
            ActivityTypeRespVO respVO = new ActivityTypeRespVO();
            respVO.setImg(acList.getAcUrl());
            respVO.setAcTitle(acList.getAcTitle());
            respVO.setAcStartTime(acList.getAcStartTime());
            respVO.setAcEndTime(acList.getAcEndTime());
            respVO.setAcType(acList.getAcType());
            list.add(respVO);
        }
        return list;
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<ActivityTypeRespVO> selectAllActivity() {
        List<Activity> activityList = activityMapper.selectAllActivity();
        if(CollectionUtils.isEmpty(activityList)){
            throw  new BusinessException(BaseResponseCode.SELECT_WECHAT_ERR);
        }
        ArrayList<ActivityTypeRespVO> list = new ArrayList<>();


        for (Activity acList : activityList){
            ActivityTypeRespVO respVO = new ActivityTypeRespVO();
            respVO.setImg(acList.getAcUrl());
            respVO.setAcTitle(acList.getAcTitle());
            respVO.setAcContent(acList.getAcContent());
            respVO.setAcStartTime(acList.getAcStartTime());
            respVO.setAcEndTime(acList.getAcEndTime());
            respVO.setAcType(acList.getAcType());
            list.add(respVO);
        }
        return list;
    }
}
