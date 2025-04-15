package com.sports.life;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sports.life.mapper")
public class SportsLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsLifeApplication.class, args);
    }

}
