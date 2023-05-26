package com.example.boardweb.dao.board;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class HitDao extends Dao {
    private HitDao() {
        super();
    }
    private static HitDao inst = null;
    public static HitDao getInst() {
        if(inst == null) inst = new HitDao();
        return inst;
    }

    public int addHit(int no){
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.update("com.example.boardweb.bean.updateHit",no);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }

        return 0;
    }
}
