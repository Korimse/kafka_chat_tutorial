package com.kafkachat.kafka_chat.controller;

import com.kafkachat.kafka_chat.constants.KafkaConstants;
import com.kafkachat.kafka_chat.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    private final SimpMessagingTemplate template;

    @PostMapping(value = "/kafka/publish")
    public void sendMessage(@RequestBody Message message) {
        log.info("Produce message : " + message.toString() + "topic : " + KafkaConstants.KAFKA_TOPIC);
        message.setTimestamp(LocalDateTime.now().toString());
        message.setId("simple");

        try {
            kafkaTemplate.send(message.getId(), message).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(
            topics = {"kafka-chat", "simple"},
            groupId = "tlkfwha"
    )
    public void listen(Message message) {
        log.info("sending via kafka listener.. ");
        template.convertAndSend("/topic/groups", message);
    }

//    @MessageMapping("/hello")
//    public void broadcastGroupMessage(@Payload Message message) {
//        System.out.println("message = " + message);
//        log.info("broadcastGroup message : " + message.toString() + "topic : " + KafkaConstants.KAFKA_TOPIC);
//        message.setTimestamp(LocalDateTime.now().toString());
//        template.convertAndSend("/topic/groups", message);
//    }

}