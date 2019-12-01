package com.ij34.cloud.ping;

import java.util.List;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.client.http.RestClient;

public class MyPingTest {

	public static void main(String[] args) throws Exception {
		// 设置请求的服务器
		ConfigurationManager.getConfigInstance().setProperty(
				"my-client.ribbon.listOfServers",
				"localhost:8080,localhost:8888");
		// 配置Ping处理类
		ConfigurationManager.getConfigInstance().setProperty(
				"my-client.ribbon.NFLoadBalancerPingClassName",
				MyPing.class.getName());
		// 配置Ping时间间隔
		ConfigurationManager.getConfigInstance().setProperty(
				"my-client.ribbon.NFLoadBalancerPingInterval",
				2);
		// 获取REST请求客户端
		RestClient client = (RestClient) ClientFactory
				.getNamedClient("my-client");
		Thread.sleep(6000);
		// 获取全部服务器
		List<Server> servers = client.getLoadBalancer().getAllServers();
		System.out.println(servers.size());
		// 输出状态
		for(Server s : servers) {
			System.out.println(s.getHostPort() + " 状态：" + s.isAlive());
		}
	}

}
