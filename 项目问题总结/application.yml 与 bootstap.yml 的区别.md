##### 1.加载顺序
- bootstrap.yml（bootstrap.properties）先加载
- application.yml（application.properties）后加载
- bootstrap.yml 用于应用程序上下文的引导阶段。
- bootstrap.yml 由父Spring ApplicationContext加载。
- 父ApplicationContext 被加载到使用 application.yml 的之前。

##### 2.配置区别
- bootstrap.yml 和 application.yml 都可以用来配置参数。
- bootstrap.yml 可以理解成系统级别的一些参数配置，这些参数一般是不会变动的。
- application.yml 可以用来定义应用级别的，如果搭配 spring-cloud-config 使用 application.yml 里面定义的文件可以实现动态替换。
- 使用Spring Cloud Config Server时，应在 bootstrap.yml 中指定：
    - [x] spring.application.name
    - [x] spring.cloud.config.server.git.uri
    - [x] 一些加密/解密信息

##### 3.注意
一旦 bootStrap.yml  被加载，则内容不会被覆盖，即便后期加载的 application.yml 的内容标签与 bootstrap 的标签一致，application  也不会覆盖 bootstrap, 而 application.yml 里面的内容可以动态替换。

