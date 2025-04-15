package com.sports.life.constant;

/**
 * 订单事件
 */
public enum OrderStatusChangeEvent {
    // 支付，发货，确认收货,退货
    PAYED,
    DELIVERY,
    RECEIVED,
    REJECTED;
}
