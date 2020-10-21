package com.example.zuul.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-21 16:29
 **/
@Data
@Document(collection="routerInfo")
public class RouterInfo {

    @Id
    private String id;

    private String path;

    private String service_id;

    private String url;

    private Boolean strip_prefix;

    private Boolean retryable;

    private Boolean enabled;

    private String description;

}
