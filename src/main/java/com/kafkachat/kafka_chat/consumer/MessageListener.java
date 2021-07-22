package com.kafkachat.kafka_chat.consumer;

import com.kafkachat.kafka_chat.constants.KafkaConstants;
import com.kafkachat.kafka_chat.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @Autowired
    SimpMessagingTemplate template;

//    @KafkaListener(
//            topics = KafkaConstants.KAFKA_TOPIC,
//            groupId = "foo"
//    )
//    public void listen(Message message) {
//        log.info("sending via kafka listener.. kafka-chat");
//        template.convertAndSend("/topic/group", message);
//    }
//
//    @KafkaListener(
//            topics = "kafka",
//            groupId = "foo"
//    )
//    public void listen2(Message message) {
//        log.info("sending via kafka listener.. kafka");
//        template.convertAndSend("/topic/group", message);
//
//    }
}