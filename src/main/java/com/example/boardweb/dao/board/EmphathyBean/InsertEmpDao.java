package com.example.boardweb.dao.board.EmphathyBean;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class InsertEmpDao extends Dao {
    public InsertEmpDao() {
        super();
    }
    private static InsertEmpDao inst = null;
    public static InsertEmpDao getInst() {
        if(inst == null) inst = new InsertEmpDao();
        return inst;
    }
    public void insertEmp(int no) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            sqlSession.selectOne("com.example.boardweb.bean.insertEmp",no);
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
