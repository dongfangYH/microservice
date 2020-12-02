package com.example.storage.service;

public interface StorageService {
    void decrease(Long productId, Integer count) throws Exception;
}
