package com.example.boardweb.dao.login;

import com.example.boardweb.bean.UserBean;
import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class LoginDao extends Dao {
    private LoginDao() {
        super();
    }
    private static LoginDao inst = null;
    public static LoginDao getInst() {
        if(inst == null) inst = new LoginDao();
        return inst;
    }
    public String checkLogin(UserBean user){
        SqlSession sqlSession = sessionFactory.openSession();
        String result = null;
        try {
            result = sqlSession.selectOne("com.example.boardweb.bean.checkLogin",user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return result;
    }
}
