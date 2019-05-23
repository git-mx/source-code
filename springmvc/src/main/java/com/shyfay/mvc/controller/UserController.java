package com.shyfay.mvc.controller;

import com.shyfay.mvc.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mx
 * @since 2019/5/22
 */
public class UserController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> userList = new ArrayList<User>();
        User userA = new User("AAAA", "AAAA");
        User userB = new User("BBBB", "BBBB");
        userList.add(userA);
        userList.add(userB);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("users", userList);
        System.out.println(this.getServletContext().getAttribute("ctxData"));
        return modelAndView;
    }
}
