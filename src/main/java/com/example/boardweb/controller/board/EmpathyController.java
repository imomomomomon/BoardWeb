package com.example.boardweb.controller.board;

import com.example.boardweb.bean.EmpathyBean;
import com.example.boardweb.controller.Controller;
import com.example.boardweb.service.BoardListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmpathyController extends Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String strTemp = request.getParameter("infoNo");
        String strflag = request.getParameter("flag");
        if(strTemp == null) {
            System.err.println("Error: Page Number is Null");
            return;
        }
        int no = Integer.parseInt(strTemp);

        String id = request.getParameter("id");
        boolean isLike = strflag.equalsIgnoreCase("like");
        boolean isInc = true;

        EmpathyBean emp = (EmpathyBean) BoardListService.getInst().getEmp(no,false);
        //선택했는지 검사 후 증가
        {
            List<String> inc = null;
            List<String> dec = null;

            //flag값에 따라서 like&dislike로 분기 & 문자열을 list로 변환
            {
                if(isLike){
                    if(emp.getArr_like() != null)
                        inc = new ArrayList<>(Arrays.asList(emp.getArr_like().split(",")));
                    else
                        inc = new ArrayList<>();
                    if(emp.getArr_dislike() != null)
                        dec = new ArrayList<>(Arrays.asList(emp.getArr_dislike().split(",")));
                    else
                        dec = new ArrayList<>();
                } else {
                    if(emp.getArr_dislike() != null)
                        inc = new ArrayList<>(Arrays.asList(emp.getArr_dislike().split(",")));
                    else
                        inc = new ArrayList<>();
                    if(emp.getArr_like() != null)
                        dec = new ArrayList<>(Arrays.asList(emp.getArr_like().split(",")));
                    else
                        dec = new ArrayList<>();
                }
            }
            //분기에 맞게 카운터 수 증감 및 아이디 입력/제거
            {
                if(inc.size() != 0 && inc.contains(id))
                    isInc = false;
                if(isInc) {
                    //flag에 따라 증가 및 감소
                    if(isLike) {
                        emp.setCnt_like(emp.getCnt_like()+1);
                    } else {
                        emp.setCnt_dislike(emp.getCnt_dislike()+1);

                    }
                    //증가쪽에 아이디가 있으면 하지않음 & 감소쪽에서 id 문자열 찾아서 제거
                    {
                        inc.add(id);
                        if(dec.size() != 0){
                            Object delete = null;
                            for (String str: dec) {
                                if(str.equalsIgnoreCase(id)){
                                    delete = str;
                                    if(isLike)
                                        emp.setCnt_dislike(emp.getCnt_dislike()!=0?emp.getCnt_dislike()-1:0);
                                    else
                                        emp.setCnt_like(emp.getCnt_like()!=0?emp.getCnt_like()-1:0);
                                    break;
                                }
                            }
                            dec.remove(delete);
                        }
                    }
                    //수정된 String List를 문자열로 바꾼후 삽입
                    {
                        if(isLike) {
                            emp.setArr_like(String.join(",",inc));
                            if(dec.size() != 0) emp.setArr_dislike(String.join(",",dec));
                            else emp.setArr_dislike(null);
                        } else {
                            emp.setArr_dislike(String.join(",",inc));
                            if(dec.size() != 0) emp.setArr_like(String.join(",",dec));
                            else emp.setArr_like(null);
                        }
                        BoardListService.getInst().updateEmp(emp);
                    }
                }
            }
            //값이 바꼈는지 아닌지 확인메세지 보내기
            throwingString(response,String.valueOf(isInc));
        }
    }


}
