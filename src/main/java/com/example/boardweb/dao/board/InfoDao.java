package com.example.boardweb.dao.board;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class InfoDao extends Dao {
    private InfoDao() {
        super();
    }

    private static InfoDao inst = null;
    public static InfoDao getInst() {
        if(inst == null) inst = new InfoDao();
        return inst;
    }
    public Object getBoardInfo(int no) {
        SqlSession sqlSession = sessionFactory.openSession();
        Object bean = null;
        try {
            bean=sqlSession.selectOne("com.example.boardweb.bean.info",no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return bean;
    }
}
