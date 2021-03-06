# Project sloth

基于 Spring Cloud Finchley.RELEASE, Spring Boot 2.0.3.RELEASE 版本开发.

### 参考文档

1. [spring cloud 官方文档](http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html)
2. [Spring Boot 2.0官方文档之 Actuator](https://blog.csdn.net/alinyua/article/details/80009435)

### 我的笔记
1. [rabbitMQ windows 上的安装使用](http://note.youdao.com/noteshare?id=0b6edbde0c742173518c3a1d7ea789d9&sub=927FD980DEB0497ABF59DFA5008DE4DE)

### 分布式云项目，使用到的技术

1. 微服务治理框架：Spring Cloud
2. 微服务项目框架：Spring Boot
3. -- 持久层框架： Mybatis with spring boot
4. -- 数据库：MySQL 5.7, Redis 4
5. -- 消息队列：RabbitMQ, ActiveMQ, Kafka.
6. -- Docker: Rancher  
7. -- 文档Api: Swagger

### 模块

#### 1. eureka-server ( 8761 )
eureka 服务端

#### 2. nt-ribbon-rest ( 19001 )
服务消费者 rest+ribbon 方式

#### 3. nt-feign ( 19002 )
服务消费者 feign 方式

#### 4. nt-zuul ( 19003 )
路由转发和过滤器 zuul

#### 5. nt-config-server ( 19004 )
云配置中心服务端

#### 6. nt-sayhi ( 20001 / 20002 )
nt-sayhi eureka 微服务客户端测试代码

#### 7. nt-bus-test ( 20003 )
测试 bus 总线刷新是否有效客户端
