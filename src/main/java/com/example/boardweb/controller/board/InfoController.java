package com.example.boardweb.controller.board;

import com.example.boardweb.bean.BoardBean;
import com.example.boardweb.component.JsonComponent;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoController extends Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String strTemp = request.getParameter("infoNo");
        if(strTemp == null) {
            System.err.println("Error: Page Number is Null");
            return;
        }
        int infoNo = Integer.parseInt(strTemp);
        BoardBean bean = (BoardBean)BoardListService.getInst().getBoardInfo(infoNo);

        if(bean != null){
            throwingString(response,JsonComponent.getInst().getStringFromObject(bean));
        } else {
            throwingString(response,"[]");
        }
    }
}
