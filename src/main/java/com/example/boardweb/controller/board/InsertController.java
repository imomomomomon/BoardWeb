package com.example.boardweb.controller.board;

import com.example.boardweb.bean.BoardBean;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;

public class InsertController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        int size = 10 * 1024 * 1024;
        String uploadPath="D:\\Intelij\\BoardWeb\\src\\main\\webapp\\upload\\";
        try {
            MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
            Enumeration e= multi.getFileNames();
            String file = (String) e.nextElement();
            {
                String contents = String.valueOf(multi.getParameter("contents"));
                String filename = null;
                if(file != null)
                    filename = multi.getOriginalFileName(file);
                Object bean = new BoardBean(multi.getParameter("category"),
                        multi.getParameter("id"),
                        multi.getParameter("title"),
                        contents.replace("\r\n","<br>"),
                        filename);
                throwingString(response,String.valueOf(BoardListService.getInst().insertBoardInfo(bean)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
