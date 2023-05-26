package com.example.boardweb.dao.board;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class DeleteDao extends Dao {
    private DeleteDao() {
        super();
    }
    private static DeleteDao inst = null;
    public static DeleteDao getInst() {
        if(inst == null) inst = new DeleteDao();
        return inst;
    }

    public int deleteDao(int no){
        SqlSession sqlSession = sessionFactory.openSession();
        int result = 0;
        try {
            result = sqlSession.delete("com.example.boardweb.bean.delete",no);
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
