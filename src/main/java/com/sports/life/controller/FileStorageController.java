package com.sports.life.controller;

import com.sports.life.utils.DataResult;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 文件存储服务
 */
@RestController
@Api(tags = "文件上传模块")
@AllArgsConstructor
@RequestMapping("/api")
public class FileStorageController {
   //@Value("${file.path}")
  final private String FILE_PATH= "F:/uploads/";
    @PostMapping("/upload")
    public DataResult<String> upload(MultipartFile file) throws IOException {
        //获取原始名称
        String originalFilename = file.getOriginalFilename();
        //生成新的文件名唯一
        String filename = UUID.randomUUID().toString() +originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成头像存储的文件夹
        byte[] bytes = file.getBytes();
        Path path = Paths.get(FILE_PATH + filename);
        Files.write(path,bytes);
        DataResult result = DataResult.success(FILE_PATH + filename);
        System.out.println("地址："+filename);
        return result;
    }
}
