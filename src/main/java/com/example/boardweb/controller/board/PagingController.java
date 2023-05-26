package com.example.boardweb.controller.board;

import com.example.boardweb.bean.PageBean;
import com.example.boardweb.component.PagingComponent;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class PagingController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String strPageNum = request.getParameter("pageNum");
        HashMap<String, Object> map = new HashMap<String,Object>();
        {//Selection & Searching
            String category = request.getParameter("category");
            if(category != null && !category.equalsIgnoreCase("All"))
                map.put("category",category);
            String search = request.getParameter("search");
            if(search != null && !search.isEmpty()) map.put("search",search);
        }

        int count = BoardListService.getInst().getCountList(map);

        PageBean page = (PageBean) request.getSession().getAttribute("page");
        if(page == null) {
            page = PagingComponent.getInst().createPageBean(5,count);
            request.getSession().setAttribute("page",page);
        } else {
            int pageNum = 1;
            if(strPageNum == null || strPageNum.equalsIgnoreCase(""))
                pageNum = page.getCurrentPage();
            else {
                pageNum = Integer.parseInt(strPageNum);
                if(pageNum <= 0) pageNum = 1;
                else if(pageNum > page.getTotalPage()) pageNum = page.getTotalPage();
            }
            PagingComponent.getInst().updateCurPage(page,pageNum,count);
        }

        {
            String msg;
            {
                msg = "{\"cur\":\""+ page.getCurrentPage() + "\""
                        + ",\"start\":\""+ page.getStartPage() + "\""
                        + ",\"end\":\""+ page.getEndPage() + "\"}";
            }
            throwingString(response,msg);
        }
    }
}
