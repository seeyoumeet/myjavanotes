package seeyoumeet.web.RabbitMQ.cosumer.Topic;//package com.seeyoumeet.web.RabbitMQ.cosumer.Topic;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Classname TopicAConsumer
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//@Component
//@RabbitListener(queues = "topic.a")
//public class TopicAConsumer {
//
//    /**
//     * 消息消费
//     * @RabbitHandler 代表此方法为接受到消息后的处理方法
//     */
//    @RabbitHandler
//    public void recieved(String msg) {
//        System.out.println("[topic.a] recieved message:" + msg);
//    }
//}
