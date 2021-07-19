package com.kafkachat.kafka_chat.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class Message implements Serializable {

    private final String author;
    private final String content;
    private final String timestamp;
}
