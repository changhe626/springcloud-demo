package cn.itcast.microservice.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderApp {


    // 向Spring容器中定义RestTemplate对象
	@Bean
    @LoadBalanced//负载均衡的支持
	public RestTemplate restTemplate(){
		//return new RestTemplate();
        //okHttp的支持
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class, args);
	}
}
