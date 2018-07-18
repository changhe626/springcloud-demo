package cn.itcast.microservice.order.service;

import cn.itcast.microservice.order.config.UrlConfig;
import cn.itcast.microservice.order.pojo.Item;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("itemService")
public class ItemService {

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;
    //2.0
    /*@Value("${itcast.item.url}")
    private String url;*/

    //4.spring cloud
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UrlConfig url;

    @Autowired
    private ItemFeignClient itemFeignClient;

    @HystrixCommand(fallbackMethod = "failMethod")
    public Item queryItemById(Long id) {
        //1.0
        /*return this.restTemplate.getForObject("http://127.0.0.1:8081/item/"
                + id, Item.class);*/

        //2.0
        //return this.restTemplate.getForObject(url + id, Item.class);

        //3.0
        //return this.restTemplate.getForObject(url.getItem().getUrl() + id, Item.class);

        //spring cloud  的实现
        /*String serviceId="itcast-microservcie-item";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if(instances==null){
            return null;
        }
        ServiceInstance instance = instances.get(0);
        String url = instance.getHost() + ":" + instance.getPort();
        return this.restTemplate.getForObject("http://" + url + "/item/" + id, Item.class);*/

        //负载均衡
        /*String serviceId="itcast-microservcie-item";
        return this.restTemplate.getForObject("http://" + serviceId + "/item/" + id, Item.class);*/

        //使用了Feign
        Item item = itemFeignClient.queryItemById(id);
        return item;

    }

    //必须和上面的方法一样的放回...
    // 请求失败执行的方法
    public Item failMethod(Long id){
        return new Item(id, "查询商品信息出错!", null, null, null);
    }



}
