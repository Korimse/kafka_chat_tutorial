package com.kafkachat.kafka_chat.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KafkaConstants {
    public static final List<String> KAFKA_TOPIC = new ArrayList<>(Arrays.asList("kafka-chat", "hello"));
    public static final String GROUP_ID = "fooing";
    public static final String KAFKA_BROKER = "localhost:9092";


}
