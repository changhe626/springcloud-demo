package cn.itcast.microservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer   //开启配置服务
@EnableDiscoveryClient   //注册到注册中心
public class ConfigApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class,args);
    }

}
