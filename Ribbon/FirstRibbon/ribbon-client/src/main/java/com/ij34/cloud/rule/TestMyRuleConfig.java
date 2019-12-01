package com.ij34.cloud.rule;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;
//修改Ribon配置让客户端使用我们的负载规则
public class TestMyRuleConfig {

	public static void main(String[] args) throws Exception {
		// 设置请求的服务器
		ConfigurationManager.getConfigInstance().setProperty(
				"my-client.ribbon.listOfServers",
				"localhost:8080,localhost:8081");
		// 配置规则处理类
		ConfigurationManager.getConfigInstance().setProperty(
				"my-client.ribbon.NFLoadBalancerRuleClassName",
				MyRule.class.getName());
		// 获取REST请求客户端
		RestClient client = (RestClient) ClientFactory
				.getNamedClient("my-client");
		// 创建请求实例
		HttpRequest request = HttpRequest.newBuilder().uri("/title/1").build();
		// 发 送100次请求到服务器中
		for (int i = 0; i < 100; i++) {
			HttpResponse response = client.executeWithLoadBalancer(request);
			String result = response.getEntity(String.class);
			System.out.println(result);
		}
	}

}
