package com.edz.mycodegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.edenz.mycodegenerator.**.mapper")
public class MyCodeGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCodeGeneratorApplication.class, args);
    }

}
