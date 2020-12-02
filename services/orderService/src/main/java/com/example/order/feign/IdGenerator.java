package com.example.order.feign;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-12-01 16:51
 **/
public class IdGenerator {
    private static final AtomicLong id = new AtomicLong(10000L);

    public static final long getId(){
        return id.getAndIncrement();
    }
}
