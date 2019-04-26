package com.shyfay.springmvc.controller;
import com.shyfay.springmvc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author mx
 * @since 2019/4/25
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static Logger logger = Logger.getLogger("what's the fuck");

    @Autowired
    TestService testService;

    public String test1(){
        logger.info("fuck you...");
        return testService.test3();
    }
}
