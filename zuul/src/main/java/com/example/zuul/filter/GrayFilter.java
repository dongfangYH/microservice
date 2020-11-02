package com.example.zuul.filter;

import com.example.zuul.gray.RibbonFilterContext;
import com.example.zuul.gray.RibbonFilterContextHolder;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-02 17:29
 **/
public class GrayFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String mark = request.getHeader("gray_mark");

        if (!StringUtils.isEmpty(mark) && "enable".equals(mark)){
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
        }else {
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
        }
        return null;
    }
}
