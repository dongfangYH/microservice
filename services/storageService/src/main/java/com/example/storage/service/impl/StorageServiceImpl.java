package com.example.storage.service.impl;

import com.example.storage.service.StorageService;
import com.example.storage.tcc.StorageTccAction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-12-01 16:40
 **/
@Service
public class StorageServiceImpl implements StorageService {
    // @Autowired
    // private StorageMapper storageMapper;

    @Resource
    private StorageTccAction storageTccAction;

    @Override
    public void decrease(Long productId, Integer count) throws Exception {
        // storageMapper.decrease(productId,count);
        storageTccAction.prepareDecreaseStorage(null, productId, count);
    }

}

