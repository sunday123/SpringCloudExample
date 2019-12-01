package com.ij34.cloud.choseserver;

import java.util.ArrayList;
import java.util.List;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
//服务器选择，服务器列表可使用listOfservers进行配置，也可以进行动态更新机制
public class ChoseServerTest {

	public static void main(String[] args) {
		// 创建负载均衡器
		BaseLoadBalancer lb = new BaseLoadBalancer();
		// 添加服务器
		List<Server> servers = new ArrayList<Server>();
		servers.add(new Server("localhost", 8080));
		servers.add(new Server("localhost", 8081));
		lb.addServers(servers);
		// 进行100次服务器选择
		for(int i = 0; i < 100; i++) {
			Server s = lb.chooseServer(null);
			System.out.println(s);
		}
	}

}
