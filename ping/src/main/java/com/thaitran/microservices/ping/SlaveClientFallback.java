package com.thaitran.microservices.ping;

import org.springframework.stereotype.Component;

@Component
public class SlaveClientFallback implements SlaveClient {
    @Override
    public String getSlaveMessage() {
        return "fallback";
    }
}
