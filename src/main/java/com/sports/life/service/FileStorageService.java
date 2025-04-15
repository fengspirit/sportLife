package com.sports.life.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件存储服务
 */
public interface FileStorageService {

    //封面和头像图片上传
    String upload(MultipartFile file) throws IOException;
}
