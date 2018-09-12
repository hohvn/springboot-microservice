# springboot-microservice
## Architecture
## Deploy 
### 1. Chạy các services cần thiết như DB, Redis, MQ, Kafka... 
```sh
$ cd docker
$ docker-compose up -d
```
### 2. Chạy các service theo thứ tự sau:
config-server -> eureka-server -> các services còn lại.

### 3. Kiểm tra các service:
* [Eureka server](http://localhost:8001): http://localhost:8001
* [API Gateway](http://localhost:8002): http://localhost:8002
* [Monitoring](http://localhost:8006): http://localhost:8006
* [Zipkin server](http://localhost:8008): http://localhost:8008
* [Hystrix Dashboard](http://localhost:8004): http://localhost:8004
> Với Hystrix dashboard có thể sử dụng turbine để kiểm tra tất cả các service với turbine server được 
> cài đặt tại: http://localhost:8003. Hoặc có thể xem từng service theo domain của từng service

## Build docker

```sh
$ ./gradlew :api-gateway:buildDocker
```