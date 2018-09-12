package com.thaitran.microservices.ping;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "command-service", fallback = CommandClientFallback.class)
public interface CommandClient {
    @GetMapping("/help")
    public String getHelp();
}
