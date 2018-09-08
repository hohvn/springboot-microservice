package com.thaitran.microservices.apigateway.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@EnableHystrix
@RefreshScope
public class ApiGatewayConfiguration {
}
