package com.seeyoumeet.eventdeal.custom.event;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description : 事件对象
 * @Modified By :
 */
public abstract class AbstractEvent {

    // 事件源
    protected Object source;

    public AbstractEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}