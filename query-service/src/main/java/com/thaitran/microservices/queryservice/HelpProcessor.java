package com.thaitran.microservices.queryservice;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import com.thaitran.microservices.queryservice.QueryServiceApplication.HelpEvent;
import com.thaitran.microservices.queryservice.QueryServiceApplication.HelpSink;

@Configuration
@EnableBinding(HelpSink.class)
public class HelpProcessor {
    @StreamListener(value = HelpSink.INPUT)
    public void apply(Message<HelpEvent> helpEventMessage) {
        System.out.println("Event received: " + helpEventMessage.getPayload().getSubject());
        //do something
    }
}
