package com.example.boardweb.dao.board.UserEmpathyBean;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class InsertUserEmpathyDao extends Dao {
    private InsertUserEmpathyDao() {
        super();
    }
    private static InsertUserEmpathyDao inst = null;
    public static InsertUserEmpathyDao getInst() {
        if (inst == null) inst = new InsertUserEmpathyDao();
        return inst;
    }
    public int insertUserEmphathy(Object obj) {
        SqlSession sqlSession = sessionFactory.openSession();
        int result = 0;
        try {
            result = sqlSession.insert("com.example.boardweb.bean.insertUserEmpathy",obj);
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
