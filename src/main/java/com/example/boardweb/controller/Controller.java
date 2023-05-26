package com.example.boardweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public abstract class Controller {
    public void throwingString(HttpServletResponse response, String str) {
        try{
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
