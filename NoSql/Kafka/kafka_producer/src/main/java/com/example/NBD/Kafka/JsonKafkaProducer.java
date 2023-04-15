package com.example.NBD.Kafka;

import com.example.NBD.Rent.Rent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Rent> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Rent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Rent data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<Rent> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
    }
}