package com.example.boardweb.controller.board;

import com.example.boardweb.bean.EmpathyBean;
import com.example.boardweb.bean.UserEmphathyBean;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;
import com.example.boardweb.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class EmpathyController extends Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String id = (String)request.getSession().getAttribute("id");
        if(id == null && id == "") return;

        String strflag = request.getParameter("flag");
        boolean isLike = strflag.equalsIgnoreCase("like");
        String strTemp = request.getParameter("infoNo");
        if(strTemp == null) {
            System.err.println("Error: Page Number is Null");
            return;
        }
        int no = Integer.parseInt(strTemp);

        UserEmphathyBean userBoard;
        {
            HashMap<String,Object> map = new HashMap<>();
            map.put("id",id);
            map.put("state","like");
            userBoard = (UserEmphathyBean) UserService.getInst().getUserBoard(map);
        }
        char div = isLike?'@':'!';
        EmpathyBean emp = null;
        // 좋&싫 로직
        {
            List<String> like = null;
            //처음 눌렀을 때 증가
            if(userBoard.getUser_like() == null){
                {
                    String add = null;
                    add = div + String.valueOf(no);
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("id",id);
                    map.put("user_like",add);
                    UserService.getInst().updateUserEmpathy(map);
                }
                //게시판 emp 증가
                emp = (EmpathyBean) BoardListService.getInst().getEmp(no);
                {
                    if(isLike)
                        emp.setCnt_like(emp.getCnt_like()+1);
                    else
                        emp.setCnt_dislike(emp.getCnt_dislike()+1);
                    BoardListService.getInst().updateEmp(emp);;
                }
                throwingString(response,"first increase");
            }
            // 이미 값이 있을때 앞에 특수문자 바꿔주고 증감
            else {
                like = new ArrayList<>(Arrays.asList(userBoard.getUser_like().split(",")));
                boolean isInc = true;
                //게시판 no 검색
                for (int i = 0; i < like.size(); i++) {
                    String value = like.get(i);
                    if(value.substring(1).equalsIgnoreCase(String.valueOf(no))){
                        //앞 특수문자를 통해 이미 좋/싫을 눌렀는지 확인
                        if(value.charAt(0) == div){
                            throwingString(response,"Can't increase");
                            return; // 똑같다면 좋/싫을 반복해서 눌렀기 때문에 종료
                        }
                        else {
                            isInc = false;
                            //찾은 값의 앞 특수문자 변경
                            like.set(i,div + value.substring(1));
                            break;
                        }
                    }
                }
                //없을 시에 추가
                if(isInc)
                    like.add(div + String.valueOf(no));
                //DB로 list를 String으로 변환해서 전송
                {
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("id",id);
                    map.put("user_like",String.join(",",like));
                    UserService.getInst().updateUserEmpathy(map);
                }

                //게시판 좋/싫 증감시키기
                emp = (EmpathyBean) BoardListService.getInst().getEmp(no);
                {
                    if(isLike) {
                        emp.setCnt_like(emp.getCnt_like()+1);
                        emp.setCnt_dislike(Math.max(emp.getCnt_dislike() - 1, 0));
                    }
                    else {
                        emp.setCnt_dislike(emp.getCnt_dislike()+1);
                        emp.setCnt_like(Math.max(emp.getCnt_like() - 1, 0));
                    }
                    BoardListService.getInst().updateEmp(emp);;
                }
                throwingString(response,"increase success");
            }
        }
    }


}
