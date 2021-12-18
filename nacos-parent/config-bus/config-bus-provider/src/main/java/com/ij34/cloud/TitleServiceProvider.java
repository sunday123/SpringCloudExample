package com.ij34.cloud;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class TitleServiceProvider {

	public static void main(String[] args) {

		SpringApplication.run(TitleServiceProvider.class,args);

	}


	@RestController
	public static class DemoController {


		@Autowired
		private ApplicationEventPublisher applicationEventPublisher;

		@Autowired
		private ServiceMatcher busServiceMatcher;

		@GetMapping("/reg")
		public String register(String username) {
			// ... 执行注册逻辑
			System.out.println("[register][执行用户({"+username+"}) 的注册逻辑]");

			// ... 发布
			UserRegisterEvent userRegisterEvent =new UserRegisterEvent(this, busServiceMatcher.getServiceId(),
					null, username);
			applicationEventPublisher.publishEvent(userRegisterEvent);
			return userRegisterEvent.toString();
		}


	}

	/**
	 * 用户注册事件
	 */
	public static class UserRegisterEvent extends RemoteApplicationEvent {

		/**
		 * 用户名
		 */
		private String username;

		public UserRegisterEvent() { // 序列化
		}

		public UserRegisterEvent(Object source, String originService, String destinationService, String username) {
			super(source, originService);
			this.username = username;
		}

		public String getUsername() {
			return username;
		}

	}
}
