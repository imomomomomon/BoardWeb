package com.example.boardweb.dao.login;

import com.example.boardweb.bean.UserBean;
import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class RegisterDao extends Dao {
    private RegisterDao() {
        super();
    }
    private static RegisterDao inst = null;
    public static RegisterDao getInst() {
        if(inst == null) inst = new RegisterDao();
        return inst;
    }
    public int registerUser(UserBean user) {
        SqlSession sqlSession = sessionFactory.openSession();
        int result = 0;
        try {
            result = sqlSession.insert("com.example.boardweb.bean.register",user);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
        return result;
    }
}
