package seeyoumeet.web.RabbitMQ.controller;//package com.seeyoumeet.web.RabbitMQ.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.com.seeyoumeet.web.bind.annotation.GetMapping;
//import org.springframework.com.seeyoumeet.web.bind.annotation.RestController;
//import com.seeyoumeet.web.RabbitMQ.producer.RabbitProducer;
//
///**
// * @Classname RabbitMqController
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//@RestController
//public class RabbitMqController {
//
//    @Autowired
//    private RabbitProducer rabbitProducer;
//
//    @GetMapping("/sendDemoQueue")
//    public Object sendDemoQueue() {
//        rabbitProducer.sendDemoQueue();
//        return "success";
//    }
//
//    @GetMapping("/sendFanout")
//    public Object sendFanout() {
//        rabbitProducer.sendFanout();
//        return "success";
//    }
//
//    @GetMapping("/sendTopicTopicAB")
//    public Object sendTopicTopicAB() {
//        rabbitProducer.sendTopicTopicAB();
//        return "success";
//    }
//
//    @GetMapping("/sendTopicTopicB")
//    public Object sendTopicTopicB() {
//        rabbitProducer.sendTopicTopicB();
//        return "success";
//    }
//
//    @GetMapping("/sendTopicTopicBC")
//    public Object sendTopicTopicBC() {
//        rabbitProducer.sendTopicTopicBC();
//        return "success";
//    }
//
//}
