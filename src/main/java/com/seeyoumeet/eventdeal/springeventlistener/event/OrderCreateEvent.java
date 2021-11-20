package com.seeyoumeet.eventdeal.springeventlistener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description : 订单创建事件
 * @Modified By :
 */

public class OrderCreateEvent extends ApplicationEvent {
    // 订单id
    private Long orderId;

    /**
     * @param source  事件源
     * @param orderId 订单id
     */
    public OrderCreateEvent(Object source, Long orderId) {
        super(source);
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
