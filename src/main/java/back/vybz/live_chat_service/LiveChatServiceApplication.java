package back.vybz.live_chat_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LiveChatServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveChatServiceApplication.class, args);
	}

}
