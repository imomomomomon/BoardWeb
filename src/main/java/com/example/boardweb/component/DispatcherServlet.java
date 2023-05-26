package com.example.boardweb.component;

import java.io.*;

import com.example.boardweb.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "dispatcher", urlPatterns = {"*.do"})
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
        Controller bc = ControllerMapper.getInst().getController(cmd);
        bc.execute(request,response);

//        if(bc.getPath() != null){
//            if(bc.isRedirect())
//                response.sendRedirect(bc.getPath());
//            else {
//                RequestDispatcher rd = request.getRequestDispatcher(bc.getPath());
//                rd.forward(request,response);
//            }
//        }
    }
}