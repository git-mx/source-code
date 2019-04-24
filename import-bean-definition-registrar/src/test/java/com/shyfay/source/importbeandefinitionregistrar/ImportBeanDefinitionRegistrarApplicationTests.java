package com.shyfay.source.importbeandefinitionregistrar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportBeanDefinitionRegistrarApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    MyAnnotationTarget annotationTarget;

	@Test
	public void contextLoads() {
	    System.out.println(annotationTarget.test());
	}

}
