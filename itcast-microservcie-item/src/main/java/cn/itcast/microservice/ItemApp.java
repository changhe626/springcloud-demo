package cn.itcast.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //申明是Eureka的客户端
public class ItemApp {

	public static void main(String[] args) {
		SpringApplication.run(ItemApp.class, args);
	}
}
