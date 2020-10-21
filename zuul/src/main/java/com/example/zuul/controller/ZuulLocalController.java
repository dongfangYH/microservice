package com.example.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-21 10:04
 **/
@RestController
public class ZuulLocalController {

    @GetMapping("/local")
    public String updateConfig(){
        return "success.";
    }
}
