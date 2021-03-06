package com.thaitran.microservices.ping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class PingApplication {
    @Autowired
    SlaveClient slaveClient;

    @Autowired
    CommandClient commandClient;

    public static void main(String[] args) {
        SpringApplication.run(PingApplication.class, args);
    }
    @Value("${test.string}")
    private String string;

    @GetMapping("/")
    public String test() {
        return slaveClient.getSlaveMessage();
    }

    @GetMapping("/stream")
    public String stream() {
        return commandClient.getHelp();
    }
}
