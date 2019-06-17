package com.spring.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author mx
 * @since 2019/6/16
 */
@Configuration
@ComponentScan({"com.spring.study.module"})
public class HelloServiceAutoConfiguration {
}
