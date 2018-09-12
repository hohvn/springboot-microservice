package com.thaitran.microservices.ping;

import org.springframework.stereotype.Component;

@Component
public class CommandClientFallback implements CommandClient {
    @Override
    public String getHelp() {
        return "help from cached";
    }
}
