package com.shyfay.source.importbeandefinitionregistrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyAnnotation
public class ImportBeanDefinitionRegistrarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportBeanDefinitionRegistrarApplication.class, args);
    }

}
