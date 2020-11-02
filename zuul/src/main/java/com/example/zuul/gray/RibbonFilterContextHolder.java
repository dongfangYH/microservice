package com.example.zuul.gray;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-02 17:15
 **/
public class RibbonFilterContextHolder {

    private static final ThreadLocal<RibbonFilterContext> contextHolder = new InheritableThreadLocal<RibbonFilterContext>(){
        @Override
        protected RibbonFilterContext initialValue() {
            return new DefaultRibbonFilterContext();
        }
    };

    public static RibbonFilterContext getCurrentContext(){
        return contextHolder.get();
    }

    public static void clearCurrentContext() {
        contextHolder.remove();
    }
}
