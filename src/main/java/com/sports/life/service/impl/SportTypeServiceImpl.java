package com.sports.life.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sports.life.entity.SportType;
import com.sports.life.exception.BusinessException;
import com.sports.life.exception.code.BaseResponseCode;
import com.sports.life.mapper.SportTypeMapper;
import com.sports.life.service.SportTypeService;
import com.sports.life.utils.PageUtil;
import com.sports.life.utils.RedisIdWork;
import com.sports.life.vo.reqVO.SportPageReqVO;
import com.sports.life.vo.respVO.PageVO;
import com.sports.life.vo.respVO.SportTypePageRespVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class SportTypeServiceImpl implements SportTypeService {

    final SportTypeMapper sportTypeMapper;
    final RedisIdWork redisIdWork;
    @Override
    public void addSportType(SportType sportType) {
        //【1】根据校验是否有相同的运动类型
        SportType type = sportTypeMapper.selectByName(sportType.getName());
        if(type!=null){
            throw  new BusinessException(BaseResponseCode.DATA_INSERT_ERR);
        }
        //【2】添加
        sportType.setId(redisIdWork.nextId("运动类型："));
        sportType.setCreateTime(new Date());
        sportType.setCreateId("测试数据，jwt完善后更改");
        sportType.setUpdateId("测试数据");
        sportType.setDeleted(0);
        int i = sportTypeMapper.insertSelective(sportType);
        if (i!=1){
            throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
        }
    }

    /**
     * 查询所有运动类型
     * @param vo
     * @return
     */
    @Override
    public PageVO<SportTypePageRespVO> selectAllSports(SportPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<SportType> sportTypes = sportTypeMapper.selectAllSprots();
        // 获取分页信息
         PageInfo<SportType> pageInfo = new PageInfo<>(sportTypes);
       //将实体类集合数据拷贝到响应VO
        List<SportTypePageRespVO> list = deepCopy(sportTypes);
        return PageUtil.getPageVoFromPageInfo(pageInfo,list);
    }

    /**
     * 拷贝数据到响应类
     * @param all
     * @return
     */
    private List<SportTypePageRespVO> deepCopy(List<SportType> all){
        ArrayList<SportTypePageRespVO> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(SportType sportType: all){
            SportTypePageRespVO respVO = new SportTypePageRespVO();
            respVO.setId(sportType.getId());
            respVO.setName(sportType.getName());
            respVO.setCreateId(sportType.getCreateId());
            respVO.setCreateTime(dateFormat.format(sportType.getCreateTime()));
            respVO.setUpdateId(sportType.getUpdateId());
            if(sportType.getUpdateTime()!=null) {
                respVO.setUpdateTime(dateFormat.format(sportType.getUpdateTime()));
            }else{
                respVO.setUpdateTime("无更新时间");
            }
            if(sportType.getDeleted()==0){
                respVO.setDeleted("正常");
            }else{
                respVO.setDeleted("封存");
            }
            list.add(respVO);
        }
        return list;

    }
}
