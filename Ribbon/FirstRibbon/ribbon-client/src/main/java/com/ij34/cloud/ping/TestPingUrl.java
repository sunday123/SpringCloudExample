package com.ij34.cloud.ping;

import java.util.ArrayList;
import java.util.List;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

public class TestPingUrl {

	public static void main(String[] args) throws Exception {
		// 创建负载均衡器
		BaseLoadBalancer lb = new BaseLoadBalancer();
		// 添加服务器
		List<Server> servers = new ArrayList<Server>();
		// 8080端口连接正常
		servers.add(new Server("localhost", 8080));
		// 一个不存在的端口
		servers.add(new Server("localhost", 8082));
		lb.addServers(servers);
		// 设置IPing实现类
		lb.setPing(new PingUrl());
		// 设置Ping时间间隔为2秒
		lb.setPingInterval(2);
		Thread.sleep(6000);
		for(Server s : lb.getAllServers()) {
			System.out.println(s.getHostPort() + " 状态：" + s.isAlive());
		}
	}

}
