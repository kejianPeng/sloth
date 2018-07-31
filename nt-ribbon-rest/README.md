# Project nt-ribbon-rest

nt-ribbon-rest 项目, 微服务调用方式: ribbon + restTemplate 

**端口号： 19000**

#### Tips

1. 访问 http://localhost:19000/ribbonHi, 多次访问，可以看到分别调用 nt-sayhi 的 20001 和 20002 端口.
2. 添加 断路器, 访问 http://localhost:19000/ribbonHi, 在服务不可用的时候，直接返回 nt-ribbon-rest error.