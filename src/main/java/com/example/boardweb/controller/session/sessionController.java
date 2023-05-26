package com.example.boardweb.controller.session;

import com.example.boardweb.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sessionController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String sessionName = request.getParameter("name");
        String action = request.getParameter("action");

        switch (action){
            case "replace":
                String value = request.getParameter("value");
                request.getSession().setAttribute(sessionName,value);
                break;
            case "delete":
                request.getSession().removeAttribute(sessionName);
                break;
        }
    }
}
