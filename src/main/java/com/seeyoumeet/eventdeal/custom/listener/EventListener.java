package com.seeyoumeet.eventdeal.custom.listener;


import com.seeyoumeet.eventdeal.custom.event.AbstractEvent;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description :
 * @Modified By :
 */
public interface EventListener<E extends AbstractEvent> {
    /**
     * 此方法负责处理事件
     *
     * @param event 要响应的事件对象，也即监听器对应的要处理的某类事件
     */
    void onEvent(E event);
}