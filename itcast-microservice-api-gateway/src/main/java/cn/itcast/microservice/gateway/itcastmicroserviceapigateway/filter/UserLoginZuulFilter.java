package cn.itcast.microservice.gateway.itcastmicroserviceapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserLoginZuulFilter  extends ZuulFilter{


    /**
     * 返回字符串代表过滤器的类型
     *  a)	pre：请求在被路由之前执行
        b)	routing：在路由请求时调用
        c)	post：在routing和errror过滤器之后调用
        d)	error：处理请求时发生错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个Boolean值，判断该过滤器是否需要执行。返回true执行，返回false不执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务逻辑
     */
    @Override
    public Object run() {
        System.out.println("进入zuul的方法了");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if("zhaojun".equals(name) && "123".equals(password)){
            context.setResponse(context.getResponse());
            return null;
        } else {
            context.setSendZuulResponse(false);  // 过滤该请求，不对其进行路由
            context.setResponseStatusCode(401);  // 设置响应状态码
        }
        return null;
    }
}
