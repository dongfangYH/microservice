
package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.StringUtils;


/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-21 10:39
 **/
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -99999;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext rqt = RequestContext.getCurrentContext();
        String auth = rqt.getRequest().getHeader("Authorization");
        if (!StringUtils.hasText(auth)){
            //禁止访问下游服务
            rqt.setSendZuulResponse(false);
            rqt.setResponseBody("no auth!");
        }
        return null;
    }
}

