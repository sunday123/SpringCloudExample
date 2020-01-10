package com.ij34.cloud;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

@RestController
@Configuration
public class TitleInvokerController {
	final Random random = new Random();
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


	  
	     @RequestMapping(value="/router",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 	public String getRouter(){
	 		return getRestTemplate().getForObject("http://ribbon-provider/title/5", String.class);
	 	}  
	     
	     
	     
	 	@Autowired
		private LoadBalancerClient loadBalancer;

		@RequestMapping(value = "/rp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ServiceInstance uselb() {
			// 查找服务器实例
			ServiceInstance si = loadBalancer.choose("ribbon-provider");
			return si;
		}
		
		
		@Autowired
		private SpringClientFactory factory;

		@RequestMapping(value = "/default", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public String defaultValue() {
			System.err.println("-----------------------输出默认配置-------------------------");
			// 获取默认的配置
			ZoneAwareLoadBalancer<?> alb = (ZoneAwareLoadBalancer<?>) factory
					.getLoadBalancer("default");
			System.err.println("IClientConfig: "
					+ factory.getLoadBalancer("default").getClass().getName());
			System.err.println("IRule: " + alb.getRule().getClass().getName());
			System.err.println("IPing: " + alb.getPing().getClass().getName());
			System.err.println("ServerList: "
					+ alb.getServerListImpl().getClass().getName());
			System.err.println("ServerListFilter: "
					+ alb.getFilter().getClass().getName());
			System.err.println("ILoadBalancer: " + alb.getClass().getName());
			System.err.println("PingInterval: " + alb.getPingInterval());
			// 获取 ribbon-provider 的配置
			System.err.println("----------------------- 获取 ribbon-provider 的配置-------------------------");
			ZoneAwareLoadBalancer<?> alb2 = (ZoneAwareLoadBalancer<?>) factory
					.getLoadBalancer("ribbon-provider");
			System.err.println("IClientConfig: "
					+ factory.getLoadBalancer("ribbon-provider").getClass()
							.getName());
			System.err.println("IRule: " + alb2.getRule().getClass().getName());
			System.err.println("IPing: " + alb2.getPing().getClass().getName());
			System.err.println("ServerList: "
					+ alb2.getServerListImpl().getClass().getName());
			System.err.println("ServerListFilter: "
					+ alb2.getFilter().getClass().getName());
			System.err.println("ILoadBalancer: " + alb2.getClass().getName());
			System.err.println("PingInterval: " + alb2.getPingInterval());
			return "";
		}
	  
}
