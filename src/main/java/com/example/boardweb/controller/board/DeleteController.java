package com.example.boardweb.controller.board;

import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String strTemp = request.getParameter("no");
        int no = 0;
        if(strTemp != null) no = Integer.parseInt(strTemp);

        if(no != 0){
            int result = BoardListService.getInst().deleteBoardInfo(no);
            throwingString(response,String.valueOf(result));
        }
    }
}
