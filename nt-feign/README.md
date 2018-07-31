# Project nt-feign

nt-feign 项目, 微服务调用方式: feign 

**端口号： 19002**

#### Tips

1. 访问 http://localhost:19002/feignHi, 多次访问，可以看到分别调用 nt-sayhi 的 20001 和 20002 端口.
2. 添加断路器， 调用 http://localhost:19002/feignHi, 在服务不可用的时候，直接返回 nt-feign error.