package com.example.boardweb.service;

import com.example.boardweb.dao.board.*;
import com.example.boardweb.dao.board.EmphathyBean.GetEmpDao;
import com.example.boardweb.dao.board.EmphathyBean.InsertEmpDao;
import com.example.boardweb.dao.board.EmphathyBean.UpdateEmpDao;
import com.example.boardweb.dao.board.BoardBean.*;

import java.util.HashMap;
import java.util.List;

public class BoardListService {
    private BoardListService() {
    }
    private static BoardListService inst = null;
    public static BoardListService getInst() {
        if(inst == null) inst = new BoardListService();
        return inst;
    }

    public List<Object> getBoradList(HashMap<String,Object> map) {
        return SelectListlDao.getInst().selectList(map);
    }

    public int getCountList(HashMap<String,Object> map) {
        return CountListDao.getInst().getCountList(map);
    }
    public List<Object> getCategoryList() {
        return CategoryListDao.getInst().getCategoryList();
    }
    public Object getBoardInfo(int no) {
        return InfoDao.getInst().getBoardInfo(no);
    }
    public void UpdateBoardInfo(HashMap<String,Object> map){
        UpdateDao.getInst().UpdateBoardInfo(map);
    }
    public Object getEmp(int no){
        return GetEmpDao.getInst().getEmp(no);
    }
    public void insertEmp(int no) { InsertEmpDao.getInst().insertEmp(no); }
    public void updateEmp(Object obj) {
        UpdateEmpDao.getInst().updateEmp(obj);
    }
    public void updateBoardInfo(HashMap<String,Object> map) {
        UpdateDao.getInst().UpdateBoardInfo(map);
    }
    public int insertBoardInfo(Object obj){
        return InsertDao.getInst().insertDao(obj);
    }
    public int deleteBoardInfo(int no) { return DeleteDao.getInst().deleteDao(no);}
    public int addHit(int no) {
        return HitDao.getInst().addHit(no);
    }
}
