package com.shyfay.mvc.config;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet是一个java编写的程序，此程序是基于HTTP协议的，在服务器端运行的（如Tomcat），是按照servlet
 * 规范编写的一个java类，主要是处理客户端的请求并将其结果发送到客户端。
 * @author mx
 * @since 2019/5/22
 */
public class CustomServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet inited ...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleLogic(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleLogic(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet destroied ...");
    }

    private void handleLogic(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("handle myLogic");
        ServletContext ctx = getServletContext();
        RequestDispatcher dispatcher = null;
        dispatcher = ctx.getRequestDispatcher("/index.jsp");
        try{
            dispatcher.forward(req, resp);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
