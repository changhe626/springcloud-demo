package cn.itcast.microservice.gateway.itcastmicroserviceapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class UserZuulFilterLog  extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        System.out.println("进入后续的方法了");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        Map<String, String[]> map = request.getParameterMap();
        StringBuffer url = request.getRequestURL();
        int port = request.getRemotePort();
        System.out.println("所有的参数是:"+map);
        System.out.println("ip是"+url+",端口号是"+port);
        return null;
    }
}
