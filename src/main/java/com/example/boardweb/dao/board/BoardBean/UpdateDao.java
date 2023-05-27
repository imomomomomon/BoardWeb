package com.example.boardweb.dao.board.BoardBean;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class UpdateDao extends Dao {
    private UpdateDao() {
        super();
    }

    private static UpdateDao inst = null;
    public static UpdateDao getInst() {
        if(inst == null) inst = new UpdateDao();
        return inst;
    }

    public void UpdateBoardInfo(HashMap<String,Object> map) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            sqlSession.update("com.example.boardweb.bean.update",map);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
