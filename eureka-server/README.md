# Project eureka-server

eureka-server 项目

**端口号： 8761**

#### Tips
1. 项目启动 banner 定制网站：http://patorjk.com/software/taag/
2. eureka 是一个高可用的组件，它没有后端缓存，每一个实例注册之后需要向注册中心发送心跳.
3. spring could 2.0版本 需要将 instance-id 的 ${spring.cloud.client.ipAddress} 改成 ${spring.cloud.client.ip-address}
4. 所有启动类可以不加注解 @EnableEurekaClient, 只需要引入包 spring-cloud-starter-netflix-eureka-client 即可， 官方说明：

```
Note that the preceding example shows a normal Spring Boot application. By having spring-cloud-starter-netflix-eureka-client on the classpath, your application automatically registers with the Eureka Server. Configuration is required to locate the Eureka server.
```
