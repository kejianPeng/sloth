# Project nt-zuul

nt-zuul 项目

**端口号： 19003**

#### Tips

1. zuul 的主要功能是路由转发和过滤器.
2. zuul 默认和Ribbon结合实现了负载均衡的功能.
3. 访问 http://localhost:19003/nt-feign/feignHi?token=1, 这时断掉 nt-feign, 返回 The service is unavailable.