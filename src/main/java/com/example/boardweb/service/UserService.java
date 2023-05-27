package com.example.boardweb.service;

import com.example.boardweb.bean.UserBean;
import com.example.boardweb.dao.board.UserEmpathyBean.GetUserBoardDao;
import com.example.boardweb.dao.board.UserEmpathyBean.InsertUserEmpathyDao;
import com.example.boardweb.dao.board.UserEmpathyBean.UpdateUserEmpathyDao;
import com.example.boardweb.dao.login.LoginDao;
import com.example.boardweb.dao.login.RegisterDao;

import java.util.HashMap;

public class UserService {
    private UserService() {
    }
    private static UserService inst = null;
    public static UserService getInst() {
        if(inst == null) inst = new UserService();
        return inst;
    }
    public String checkLogin(UserBean user){
        return LoginDao.getInst().checkLogin(user);
    }
    public int registerUser(UserBean user) { return RegisterDao.getInst().registerUser(user); }
    public Object getUserBoard(HashMap<String,Object> map) {
        Object obj = GetUserBoardDao.getInst().getUserEmpathy(map);
        if(obj == null){
            if(InsertUserEmpathyDao.getInst().insertUserEmphathy(map) != 0)
                return GetUserBoardDao.getInst().getUserEmpathy(map);
            return null;
        }
        return GetUserBoardDao.getInst().getUserEmpathy(map);
    }
    public int updateUserEmpathy(HashMap<String,Object> map) {
        return UpdateUserEmpathyDao.getInst().updateUserEmpathy(map);
    }
    public int insertUserEmpathy(Object obj) {
        return InsertUserEmpathyDao.getInst().insertUserEmphathy(obj);
    }
}
