package com.ij34.cloud;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class MyPing implements IPing {

	public boolean isAlive(Server server) {
		System.out.println("这是自定义Ping实现类：" + server.getHostPort());
		return true;
	}
}
