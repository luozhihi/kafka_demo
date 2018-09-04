package com.sensetime.kafka_demo;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMsg(String topic,String msg){
        log.error("推送消息"+msg);
        try {
            // 推送消息
            kafkaTemplate.send(topic,msg);
        }catch (Exception e){
            log.error("推送消息 "+msg+" 失败");
        }

        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(ProducerRecord<String, String> producerRecord, RecordMetadata recordMetadata) {
//                producerRecord.
                log.info("onSuccess1");
            }

            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
                log.info("onSuccess2");
            }

            @Override
            public void onError(ProducerRecord<String, String> producerRecord, Exception exception) {
                log.info("onError1");
            }

            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
                log.info("onError2");
            }
        });
    }


}
