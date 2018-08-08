# Project nt-sayhi

nt-sayhi 项目, 微服务客户端测试代码

**端口号： 20001 / 20002 **

#### Tips

1. 启动多个实例方法：启动配置添加 -Dserver.port=20002，可以在20002端口启动项目
2. 启动类 SayHiApplication 可以不加注解 @EnableEurekaClient, 该版本只需要引入包 spring-cloud-starter-netflix-eureka-client 即可， 官方说明：

```
Note that the preceding example shows a normal Spring Boot application. By having spring-cloud-starter-netflix-eureka-client on the classpath, your application automatically registers with the Eureka Server. Configuration is required to locate the Eureka server.
```
3. 重新拉取配置中心配置：
执行 http://localhost:20001/hi ==> Hi, cloud test repo - prod, port = 20001
更新 git nt-sayhi-prod.yml 文件内容： name: cloud test repo - prod(2)
执行 post 请求： http://localhost:20001/actuator/refresh ==> ["config.client.version","test.name"]
执行 http://localhost:20001/hi ==> Hi, cloud test repo - prod(2), port = 20001

4. 
