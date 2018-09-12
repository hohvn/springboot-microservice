package com.thaitran.microservices.commandservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thaitran.microservices.commandservice.CommandServiceApplication.HelpSource;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@RestController
@EnableBinding(HelpSource.class)
public class CommandServiceApplication {
    @Autowired
    HelpSource helpSource;
    public static void main(String[] args) {
        SpringApplication.run(CommandServiceApplication.class, args);
    }

    @GetMapping("/help")
    public String help() {
        //do something before publish event

        helpSource.helpOutBound().send(MessageBuilder.withPayload(new HelpEvent(new Date().toString(), EventType.WANT_OTHER_HELP)).build());
        return "Done";
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

    interface HelpSource {
        String OUTPUT = "help-output";
        @Output(OUTPUT)
        MessageChannel helpOutBound();
    }
}
