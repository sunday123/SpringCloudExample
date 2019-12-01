# Ribbon
负载均衡项目
- RoundRobinRule：系统默认的规则，通过简单地轮询服务列表来选择服务器，其他规则在很多情况下仍然使用RoundRobinRule。
- AvailabilityFilteringRule：该规则会忽略以下服务器。
-无法连接的服务器：在默认情况下，如果3次连接失败，该服务器将会被置为“短路”的状态，该状态将持续30秒；如果再次连接失败，“短路”状态的持续时间将会以几何级数增加。可以通过修改niws.loadbalancer.<clientName>.connection-FailureCountThreshold属性，来配置连接失败的次数。
并发数过高的服务器：如果连接到该服务器的并发数过高，也会被这个规则忽略，可以通过修改＜clientName>.ribbon.ActiveConnectionsLirnit属性来设定最高并发数。
- WeightedResponseTimeRule：为每个服务器赋予一个权重值，服务器的响应时间越长，该权重值就越少，这个规则会随机选择服务器，权重值有可能会决定服务器的选择。
- ZoneAvoidanceRule：该规则以区域、可用服务器为基础进行服务器选择。使用Zone对服务器进行分类，可以理解为机架或者机房。
- BestAvailableRule：忽略“短路”的服务器，并选择并发数较低的服务器。
- RandomRule：顾名思义，随机选择可用的服务器
- RetryRule：含有重试的选择逻辑，如果使用RoundRobinRule选择的服务器无法连接，那么将会重新选择服务器。

### 其他配置
- NFLoadBalancerClassName：指定负载均衡器的实现类，可利用该配置实现自己的负载均衡器。
- NIWSServerListClassName：服务器列表处理类，用来维护服务器列表，Ribbon己经实现动态服务器列表。
- NIWSServerListFilterClassName：用于处理服务器列表拦截。
