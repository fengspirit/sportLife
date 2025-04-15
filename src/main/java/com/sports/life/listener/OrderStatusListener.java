package com.sports.life.listener;

import com.sports.life.constant.OrderStatus;
import com.sports.life.entity.OrderDetail;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 监听订单状态
 */
@Transactional
@WithStateMachine
@Component
public class OrderStatusListener {


    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message message){
        OrderDetail order = (OrderDetail) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.WAIT_DELIVER.getKey());
        System.out.println("支付，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }
}
