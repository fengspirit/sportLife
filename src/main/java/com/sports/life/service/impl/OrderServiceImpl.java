package com.sports.life.service.impl;

import com.sports.life.constant.OrderStatus;
import com.sports.life.constant.OrderStatusChangeEvent;
import com.sports.life.entity.OrderDetail;
import com.sports.life.exception.BusinessException;
import com.sports.life.exception.code.BaseResponseCode;
import com.sports.life.mapper.OrderDetailMapper;
import com.sports.life.service.OrderService;
import com.sports.life.service.RedisService;
import com.sports.life.utils.CodeUtil;
import com.sports.life.utils.RedisIdWork;
import com.sports.life.vo.reqVO.order.OrderDetailAddVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

/**
 * 订单服务层
 */
@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    final StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;
    final RedisIdWork redisIdWork;
    final RedisService redisService;
    final TransactionTemplate transactionTemplate;
    final OrderDetailMapper orderDetailMapper;

    /**
     * 订单创建:
     * 1:订单本身创建
     * 2：报名表报名人数根据订单报名人数减少
     * 3：
     * @param vo
     */
    @Override
    public void create(OrderDetailAddVO vo) {
        //封装数据
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(vo,orderDetail);
        //订单ID+订单编号
        long orderId = redisIdWork.nextId("订单：");
        long codeKey = redisService.incrby("activity_code_key", 1);
        String code = CodeUtil.orderCode(String.valueOf(codeKey), 6, "0");
        orderDetail.setId(orderId);
        orderDetail.setOrderCode(code);
        orderDetail.setOrderStatus(OrderStatus.WAIT_PAYMENT.getKey());
        orderDetail.setOrderTime(new Date());

        int insertSelective = orderDetailMapper.insertSelective(orderDetail);
        if(insertSelective!=1){
            throw new BusinessException(BaseResponseCode.DATA_INSERT_ERR);
        }
    }
}
