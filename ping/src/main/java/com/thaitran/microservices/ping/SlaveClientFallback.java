package com.thaitran.microservices.ping;

import org.springframework.stereotype.Component;

@Component
public class SlaveClientFallback implements SlaveClient {
    @Override
    public String getSlaveMessage() {
        // We can get the data in cache of this service,
        // or we can do anything incase destination has problems
        return "fallback";
    }
}
