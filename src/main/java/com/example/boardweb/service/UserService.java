package com.example.boardweb.service;

import com.example.boardweb.bean.UserBean;
import com.example.boardweb.dao.login.LoginDao;
import com.example.boardweb.dao.login.RegisterDao;

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
}
