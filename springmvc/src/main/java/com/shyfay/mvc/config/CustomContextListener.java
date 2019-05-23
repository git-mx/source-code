package com.shyfay.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author mx
 * @since 2019/5/22
 */
public class CustomContextListener implements ServletContextListener {

    private ServletContext context = null;

    public CustomContextListener(){

    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.context = servletContextEvent.getServletContext();
        context.setAttribute("ctxData", "this is servletContext attribute...");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.context = null;
    }
}
