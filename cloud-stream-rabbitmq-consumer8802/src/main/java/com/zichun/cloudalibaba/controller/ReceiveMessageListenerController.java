package com.zichun.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/2 18:51
 */
//@Component
//@EnableBinding(Sink.class)
//public class ReceiveMessageListenerController {
//
//    @Value("${server.port}")
//    private String serverPort;
//
//    @StreamListener(Sink.INPUT)
//    public void input(Message<String> message) {
//        System.out.println("消费者一号,---> 接收到的消息" + message.getPayload() + "\t  port: "+ serverPort);
//    }
//
//}
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController
{
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message)
    {
        System.out.println("消费者1号，------->接收到的消息：" + message.getPayload()+"\t port: "+serverPort);
    }
}
