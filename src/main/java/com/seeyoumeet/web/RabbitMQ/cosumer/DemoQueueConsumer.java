package seeyoumeet.web.RabbitMQ.cosumer;//package com.seeyoumeet.web.RabbitMQ.cosumer;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Classname DemoQueueConsumer
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//@Component
//@RabbitListener(queues = "demoQueue")
//public class DemoQueueConsumer {
//
//    /**
//     * 消息消费
//     * @RabbitHandler 代表此方法为接受到消息后的处理方法
//     */
//    @RabbitHandler
//    public void recieved(String msg) {
//        System.out.println("[demoQueue] recieved message: " + msg);
//    }
//
//}
//
