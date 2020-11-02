package com.example.zuul.gray;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-02 17:24
 **/
public class MetadataAwareRule extends DiscoveryEnabledRule{

    public MetadataAwareRule() {
        this(new MetadataAwarePredicate());
    }

    public MetadataAwareRule(DiscoveryEnabledPredicate predicate) {
        super(predicate);
    }
}
