package com.seeyoumeet.eventdeal.custom.multicaster;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description :
 * @Modified By :
 */

import com.seeyoumeet.eventdeal.custom.event.AbstractEvent;
import com.seeyoumeet.eventdeal.custom.listener.EventListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 事件广播器简单实现
 */
public class SimpleEventMulticaster implements EventMulticaster {

    private Map<Class<?>, List<EventListener>> eventObjectEventListenerMap = new ConcurrentHashMap<>();

    public SimpleEventMulticaster() {

    }

    public SimpleEventMulticaster(EventListener eventListener) {
        addEventListener(eventListener);
    }

    public SimpleEventMulticaster(List<EventListener> eventListeners) {
        if (eventListeners != null) {
            eventListeners.forEach(this::addEventListener);
        }
    }

    @Override
    public void multicastEvent(AbstractEvent event) {
        List<EventListener> eventListeners = this.eventObjectEventListenerMap.get(event.getClass());
        if (eventListeners != null) {
            for (EventListener eventListener : eventListeners) {        // 执行所有监听了该类事件的监听器的onEvent()方法
                eventListener.onEvent(event);
            }
        }
    }

    @Override
    public void addEventListener(EventListener<?> listener) {
        Class<?> eventType = this.getEventType(listener);
        List<EventListener> eventListeners = this.eventObjectEventListenerMap.get(eventType);
        if (eventListeners == null) {
            eventListeners = new ArrayList<>();
            this.eventObjectEventListenerMap.put(eventType, eventListeners);
        }
        eventListeners.add(listener);
    }

    @Override
    public void removeEventListener(EventListener<?> listener) {
        Class<?> eventType = this.getEventType(listener);
        List<EventListener> eventListeners = this.eventObjectEventListenerMap.get(eventType);
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    /**
     * 获取事件监听器需要监听的事件类型
     * @param listener
     * @return
     */
    protected Class<?> getEventType(EventListener listener) {
        ParameterizedType parameterizedType = (ParameterizedType) listener.getClass().getGenericInterfaces()[0];
        Type eventType = parameterizedType.getActualTypeArguments()[0];
        return (Class<?>) eventType;
    }

}
