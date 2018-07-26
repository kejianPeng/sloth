# Project sloth

基于 Spring Cloud Finchley.RELEASE, Spring Boot 2.0.3.RELEASE 版本开发.

### 参考文档

1. [spring cloud 官方文档](http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html)

### 分布式云项目，使用到的技术

1. 微服务治理框架：Spring Cloud
2. 微服务项目框架：Spring Boot
3. -- 持久层框架： Mybatis with spring boot
4. -- 数据库：MySQL 5.7, Redis 4
5. -- 消息队列：ActiveMQ, Kafka.
6. -- Docker: Rancher  
7. -- 文档Api: Swagger

### 微服务模块

#### 1. eureka-server
eureka 服务端
port: 8761

#### 2. nt-sayhi
nt-sayhi 微服务客户端测试代码
port: 20001