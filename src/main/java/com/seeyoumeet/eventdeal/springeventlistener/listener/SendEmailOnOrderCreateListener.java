package com.seeyoumeet.eventdeal.springeventlistener.listener;

import com.seeyoumeet.eventdeal.springeventlistener.event.OrderCreateEvent;
import org.springframework.stereotype.Component;
/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description :
 * @Modified By :
 */

/**
 * 订单创建成功给用户发送邮件
 */
@Component
public abstract class SendEmailOnOrderCreateListener implements ApplicationListener<OrderCreateEvent> {

    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        System.out.println(String.format("订单【%d】创建成功，给下单人发送邮件通知!", event.getOrderId()));
    }
}
