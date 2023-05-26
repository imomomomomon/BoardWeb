package com.example.boardweb.controller.login;

import com.example.boardweb.bean.UserBean;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String result = UserService.getInst().checkLogin(new UserBean(id,password));

        if(result != null) {
            request.getSession().setAttribute("id",id);
            request.getSession().setMaxInactiveInterval(60 * 10 * 10);
            throwingString(response,result);
        }
        else
            throwingString(response,"[아이디/비밀번호가 틀렸습니다.]");
    }
}
