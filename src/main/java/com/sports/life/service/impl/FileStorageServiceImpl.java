package com.sports.life.service.impl;

import com.sports.life.service.FileStorageService;
import com.sports.life.utils.DataResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {
    final private String FILE_PATH= "F:/uploads/";
    @Override
    public String upload(MultipartFile file) throws IOException {
        //获取原始名称
        String originalFilename = file.getOriginalFilename();
        //生成新的文件名唯一
        String filename = UUID.randomUUID().toString() +originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成头像存储的文件夹
        byte[] bytes = file.getBytes();
        Path path = Paths.get(FILE_PATH + filename);
        Files.write(path,bytes);
       String url = "http://127.0.0.1:8081/uploads/" + filename;

        return url;
    }
}
