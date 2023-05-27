package com.example.boardweb.dao.board.EmphathyBean;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

public class GetEmpDao extends Dao {
    private GetEmpDao() { super();}
    private static GetEmpDao inst = null;
    public static GetEmpDao getInst() {
        if(inst == null) inst = new GetEmpDao();
        return inst;
    }
    public Object getEmp(int no) {
        SqlSession sqlSession = sessionFactory.openSession();
        Object obj = null;
        try {
            obj = sqlSession.selectOne("com.example.boardweb.bean.getEmp",no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return obj;
    }
}
