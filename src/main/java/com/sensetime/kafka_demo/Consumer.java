package com.sensetime.kafka_demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = {"topic_1","topic_2"})
    public void msgConsumer(String content){
        System.err.println("消息被消费："+content);
    }
}
