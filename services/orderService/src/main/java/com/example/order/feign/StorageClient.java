package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-12-01 16:51
 **/
@FeignClient(name = "storage")
public interface StorageClient {
    @GetMapping("/decrease")
    String decrease(@RequestParam(value = "productId") Long productId,
                    @RequestParam(value = "count") Integer count);
}
