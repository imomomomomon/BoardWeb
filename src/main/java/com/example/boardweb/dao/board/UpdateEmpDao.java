package com.example.boardweb.dao.board;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class UpdateEmpDao extends Dao {
    private UpdateEmpDao() {
        super();
    }
    private static UpdateEmpDao inst = null;
    public static UpdateEmpDao getInst() {
        if(inst == null) inst = new UpdateEmpDao();
        return inst;
    }

    public void updateEmp(Object obj){
        SqlSession sqlSession = sessionFactory.openSession();

        try {
            sqlSession.update("com.example.boardweb.bean.updateEmp",obj);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }

    }
}
