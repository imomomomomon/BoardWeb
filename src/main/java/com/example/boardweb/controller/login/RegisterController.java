package com.example.boardweb.controller.login;

import com.example.boardweb.bean.UserBean;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int result = UserService.getInst().registerUser(
                new UserBean(request.getParameter("id"),
                        request.getParameter("password")));
        throwingString(response, String.valueOf(result));
    }
}
