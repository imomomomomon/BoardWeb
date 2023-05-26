package com.example.boardweb.controller.board;

import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;

public class UpdateController extends Controller {
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
                map.put("no",multi.getParameter("no"));
                map.put("category",multi.getParameter("category"));
                map.put("title",multi.getParameter("title"));
                String contents = String.valueOf(multi.getParameter("contents"));
                map.put("contents",contents.replace("\r\n","<br>"));
                if(file != null)
                    map.put("filename",multi.getOriginalFileName(file));

                BoardListService.getInst().updateBoardInfo(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
