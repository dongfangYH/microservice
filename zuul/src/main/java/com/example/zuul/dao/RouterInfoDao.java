package com.example.zuul.dao;

import com.example.zuul.entity.RouterInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouterInfoDao extends MongoRepository<RouterInfo, String> {

    List<RouterInfo> findAllByEnabledTrue();
}
