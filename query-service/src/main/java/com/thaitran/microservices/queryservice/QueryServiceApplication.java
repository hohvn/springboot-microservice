package com.thaitran.microservices.queryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;

import com.thaitran.microservices.queryservice.QueryServiceApplication.HelpSink;

@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient

public class QueryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QueryServiceApplication.class, args);
    }

    interface HelpSink extends Sink {
        String INPUT = "help-consummer";

        @Input(HelpSink.INPUT)
        SubscribableChannel helpInput();
    }


    public static class HelpEvent {
        private String subject;
        private EventType eventType;

        public HelpEvent() {}
        public HelpEvent(String subject, EventType eventType) {
            this.subject = subject;
            this.eventType = eventType;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public EventType getEventType() {
            return eventType;
        }

        public void setEventType(EventType eventType) {
            this.eventType = eventType;
        }
    }

    enum EventType {
        WANT_OTHER_HELP
    }
}
