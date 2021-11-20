package com.seeyoumeet.eventdeal.springeventlistener.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description : 自定义事件监听器
 * @Modified By :
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
