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