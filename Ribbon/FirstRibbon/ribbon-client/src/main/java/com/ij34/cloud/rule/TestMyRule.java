package com.ij34.cloud.rule;

import java.util.ArrayList;
import java.util.List;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

public class TestMyRule {

	public static void main(String[] args) {
		// 创建负载均衡器
		BaseLoadBalancer lb = new BaseLoadBalancer();
		// 设置自定义的负载规则
		lb.setRule(new MyRule(lb));
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
