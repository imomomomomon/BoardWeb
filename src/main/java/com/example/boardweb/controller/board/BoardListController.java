package com.example.boardweb.controller.board;

import com.example.boardweb.bean.PageBean;
import com.example.boardweb.component.JsonComponent;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;

public class BoardListController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        PageBean page = (PageBean) request.getSession().getAttribute("page");
        if(page != null){
            HashMap<String, Object> map = new HashMap<>();
            map.put("start",page.getStartNode());
            map.put("end",page.getEndNode());
            {//Selection & Searching
                String category = request.getParameter("category");
                if(category != null && !category.equalsIgnoreCase("All"))
                    map.put("category",category);
                String search = request.getParameter("search");
                if(search != null && !search.isEmpty()) map.put("search",search.trim());
                //set session value
                request.getSession().setAttribute("category",category);
                request.getSession().setAttribute("search",search);
            }
            List<Object> list = BoardListService.getInst().getBoradList(map);


            if(!list.isEmpty())
                throwingString(response,JsonComponent.getInst().getStringFromList(list));
            else
                throwingString(response,"[]");

        } else {
            System.err.println("Error:Failed loading session value('page')");
        }
    }
}
