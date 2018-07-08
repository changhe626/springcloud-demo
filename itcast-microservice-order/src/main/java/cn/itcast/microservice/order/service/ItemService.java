package cn.itcast.microservice.order.service;

import cn.itcast.microservice.order.config.UrlConfig;
import cn.itcast.microservice.order.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("itemService")
public class ItemService {

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;

    //2.0
    /*@Value("${itcast.item.url}")
    private String url;*/

    @Autowired
    private UrlConfig url;

    public Item queryItemById(Long id) {
        //1.0
        /*return this.restTemplate.getForObject("http://127.0.0.1:8081/item/"
                + id, Item.class);*/

        //2.0
        //return this.restTemplate.getForObject(url + id, Item.class);

        //3.0
        return this.restTemplate.getForObject(url.getItem().getUrl() + id, Item.class);

    }

}
