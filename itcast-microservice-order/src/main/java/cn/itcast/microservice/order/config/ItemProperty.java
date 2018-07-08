package cn.itcast.microservice.order.config;

import org.springframework.beans.factory.annotation.Value;

public class ItemProperty {

    //必须交url这个名字,否则注入不了...
    private String url;


    public ItemProperty(String url) {
        this.url = url;
    }

    public ItemProperty() {
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
