package cn.itcast.microservice.order.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "itcast")
public class UrlConfig {


    //这个item 的名字必须和itcast.item.url   中间的那个item一致,同理
    //item对象中的对象必须交url
    private ItemProperty item=new ItemProperty();

    public UrlConfig(ItemProperty item) {
        this.item = item;
    }

    public UrlConfig() {
    }



    public ItemProperty getItem() {
        return item;
    }

    public void setItem(ItemProperty item) {
        this.item = item;
    }
}
