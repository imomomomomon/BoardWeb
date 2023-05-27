package com.example.boardweb.dao.board.BoardBean;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class InsertDao extends Dao {
    private InsertDao() {
        super();
    }
    private static InsertDao inst = null;
    public static InsertDao getInst() {
        if(inst == null) inst = new InsertDao();
        return inst;
    }
    public int insertDao(Object obj) {
        SqlSession sqlSession = sessionFactory.openSession();
        int result = 0;
        try {
            result = sqlSession.insert("com.example.boardweb.bean.insert",obj);
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
