package com.thaitran.microservices.ping;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "slave", fallback = SlaveClientFallback.class)
public interface SlaveClient {
    @GetMapping("/")
    public String getSlaveMessage();
}
