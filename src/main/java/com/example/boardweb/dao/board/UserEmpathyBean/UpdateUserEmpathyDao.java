package com.example.boardweb.dao.board.UserEmpathyBean;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class UpdateUserEmpathyDao extends Dao {
    private UpdateUserEmpathyDao() {
        super();
    }
    private static UpdateUserEmpathyDao inst = null;
    public static UpdateUserEmpathyDao getInst() {
        if (inst == null) inst = new UpdateUserEmpathyDao();
        return inst;
    }
    public int updateUserEmpathy(HashMap<String,Object> map) {
        SqlSession sqlSession = sessionFactory.openSession();
        int result = 0;
        try {
            result = sqlSession.update("com.example.boardweb.bean.updateUserEmpathy",map);
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
