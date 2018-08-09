# Project nt-config-server

nt-config-server 项目, 分布式配置中心的服务端

**端口号： 19004**

### 介绍 :
在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。在Spring Cloud中，有分布式配置中心组件spring cloud config ，它支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中。在spring cloud config 组件中，分两个角色，一是config server，二是config client。  

证明配置服务中心可以从远程程序获取配置信息。

http请求地址和资源文件映射如下:

    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties

### 启动方式 :
<font color=red>前置条件:</font>启动Eureka集群, 注意参数的配置集群是否正确. 

#### Tips

1. 添加云配置中心客户端的时候，如果是 github 或者码云，直接使用 https://github.com/kejianPeng/springcloud-repo 即可，如果是公司自己搭建的 gitlab, 则需要加上 .git 后缀，如：http://172.16.0.10/company/nt-config-repo.git
2. spring.cloud.config.server.git.searchPaths: 定义了配置文件搜索的位置，可以配置多个，多个之间用逗号分隔。
3. spring cloud 2.0 之后，客户端需要手动配置 management.endpoints.web.exposure.include=refresh,health,info 才可以调用 /refresh 接口
4. 访问链接举例： http://localhost:19004/nt-sayhi/prod/master
5. 在客户端添加 bus 总线，在服务端配置文件有更新的时候，客户端发出请求，相关的配置会全部更新
6. 上面这种方法并不优雅：
- 打破了微服务的职责单一性。微服务本身是业务模块，它本不应该承担配置刷新的职责。
- 破坏了微服务各节点的对等性。
- 有一定的局限性。例如，微服务在迁移时，它的网络地址常常会发生变化，此时如果想要做到自动刷新，那就不得不修改WebHook的配置。
7. 所以直接在该项目添加 bus 总线，调用该项目的 bus-refresh, 将所有更新的配置刷新到各个微服务中。

```
C:\Users\thinkpad>curl -X POST http://localhost:19004/actuator/bus-refresh
```

config server:
```
2018-08-09 14:47:43.640  WARN 1944 --- [io-19004-exec-2] com.netflix.discovery.DiscoveryClient    : Saw local status change event StatusChangeEvent [timestamp=1533797263640, current=UP, previous=DOWN]
2018-08-09 14:47:43.640  INFO 1944 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_NT-CONFIG-SERVER/192.168.18.186:19004: registering service...
2018-08-09 14:47:43.641  INFO 1944 --- [io-19004-exec-2] o.s.cloud.bus.event.RefreshListener      : Received remote refresh request. Keys refreshed []
2018-08-09 14:47:43.652  INFO 1944 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_NT-CONFIG-SERVER/192.168.18.186:19004 - registration status: 204
2018-08-09 14:47:45.476  INFO 1944 --- [io-19004-exec-3] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@101a16f0: startup date [Thu Aug 09 14:47:45 CST 2018]; root of context hierarchy
2018-08-09 14:47:45.490  INFO 1944 --- [io-19004-exec-3] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
2018-08-09 14:47:45.490  INFO 1944 --- [io-19004-exec-3] o.s.c.c.s.e.NativeEnvironmentRepository  : Adding property source: file:/C:/Users/thinkpad/AppData/Local/Temp/config-repo-8557540477964928881/test-repo/nt-sayhi-prod.yml
2018-08-09 14:47:45.490  INFO 1944 --- [io-19004-exec-3] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@101a16f0: startup date [Thu Aug 09 14:47:45 CST 2018]; root of context hierarchy
2018-08-09 14:47:48.062  INFO 1944 --- [io-19004-exec-5] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@58b977d9: startup date [Thu Aug 09 14:47:48 CST 2018]; root of context hierarchy
2018-08-09 14:47:48.070  INFO 1944 --- [io-19004-exec-5] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
2018-08-09 14:47:48.071  INFO 1944 --- [io-19004-exec-5] o.s.c.c.s.e.NativeEnvironmentRepository  : Adding property source: file:/C:/Users/thinkpad/AppData/Local/Temp/config-repo-8557540477964928881/test-repo/nt-sayhi-prod.yml
2018-08-09 14:47:48.071  INFO 1944 --- [io-19004-exec-5] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@58b977d9: startup date [Thu Aug 09 14:47:48 CST 2018]; root of context hierarchy
```

nt-bus-test:

```
2018-08-09 14:47:43.106  INFO 1944 --- [io-19004-exec-4] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@24b0a0db: startup date [Thu Aug 09 14:47:43 CST 2018]; root of context hierarchy
2018-08-09 14:47:43.106  INFO 1944 --- [io-19004-exec-4] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
2018-08-09 14:47:43.121  INFO 1944 --- [io-19004-exec-4] o.s.c.c.s.e.NativeEnvironmentRepository  : Adding property source: file:/C:/Users/thinkpad/AppData/Local/Temp/config-repo-8557540477964928881/test-repo/nt-bus-test-prod.yml
2018-08-09 14:47:43.121  INFO 1944 --- [io-19004-exec-4] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@24b0a0db: startup date [Thu Aug 09 14:47:43 CST 2018]; root of context hierarchy
2018-08-09 14:47:43.475  INFO 1944 --- [io-19004-exec-2] com.netflix.discovery.DiscoveryClient    : Unregistering ...
2018-08-09 14:47:43.500  INFO 1944 --- [io-19004-exec-2] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_NT-CONFIG-SERVER/192.168.18.186:19004 - deregister  status: 200
2018-08-09 14:47:43.515  INFO 1944 --- [io-19004-exec-2] com.netflix.discovery.DiscoveryClient    : Completed shut down of DiscoveryClient
```


nt-sayhi: 20001

```
2018-08-09 14:47:46.580  WARN 22444 --- [86HHNmJ3VshmQ-1] com.netflix.discovery.DiscoveryClient    : Saw local status change event StatusChangeEvent [timestamp=1533797266580, current=UP, previous=DOWN]
2018-08-09 14:47:46.580  INFO 22444 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_NT-SAYHI/192.168.18.186:20001: registering service...
2018-08-09 14:47:46.580  INFO 22444 --- [86HHNmJ3VshmQ-1] o.s.cloud.bus.event.RefreshListener      : Received remote refresh request. Keys refreshed [config.client.version, test.name]
2018-08-09 14:47:46.580  INFO 22444 --- [86HHNmJ3VshmQ-1] o.s.a.r.c.CachingConnectionFactory       : Attempting to connect to: [127.0.0.1:5672]
2018-08-09 14:47:46.595  INFO 22444 --- [nfoReplicator-0] com.netflix.discovery.DiscoveryClient    : DiscoveryClient_NT-SAYHI/192.168.18.186:20001 - registration status: 204
2018-08-09 14:47:46.595  INFO 22444 --- [86HHNmJ3VshmQ-1] o.s.a.r.c.CachingConnectionFactory       : Created new connection: rabbitConnectionFactory.publisher#37285dd1:0/SimpleConnection@1f61d3bc [delegate=amqp://admin@127.0.0.1:5672/, localPort= 50257]
2018-08-09 14:47:46.595  INFO 22444 --- [86HHNmJ3VshmQ-1] o.s.amqp.rabbit.core.RabbitAdmin         : Auto-declaring a non-durable, auto-delete, or exclusive Queue (springCloudBus.anonymous.OKQT4PilQ86HHNmJ3VshmQ) durable:false, auto-delete:true, exclusive:true. It will be redeclared if the broker stops and is restarted while the connection factory is alive, but all messages will be lost.
```

