package com.sports.life.proxy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class ProxyController {
    private static final String TENCENT_API = "https://apis.map.qq.com/ws/place/v1/search";

    @GetMapping("/api/search")
    public ResponseEntity<String> proxySearch(
            @RequestParam String keyword,
            @RequestParam String boundary,
            @RequestParam String key) throws IOException {

        System.out.println("进入代理方法");
        String url = String.format("%s?keyword=%s&boundary=%s&key=%s",
                TENCENT_API,
                URLEncoder.encode(keyword, "UTF-8"),
                URLEncoder.encode(boundary, "UTF-8"),
                key);

        // 使用HttpClient或RestTemplate转发请求
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }
}