package com.example.boardweb.controller.board;

import com.example.boardweb.bean.EmpathyBean;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CntEmpController extends Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String strTemp = request.getParameter("infoNo");
        if(strTemp == null) {
            System.err.println("Error: Page Number is Null");
            return;
        }
        int no = Integer.parseInt(strTemp);

        EmpathyBean emp = (EmpathyBean) BoardListService.getInst().getEmp(no);
        if(emp == null){
            BoardListService.getInst().insertEmp(no);
            emp = (EmpathyBean) BoardListService.getInst().getEmp(no);
        }

        String msg = emp.getCnt_like() + "," + emp.getCnt_dislike();
        throwingString(response,msg);
    }
}
