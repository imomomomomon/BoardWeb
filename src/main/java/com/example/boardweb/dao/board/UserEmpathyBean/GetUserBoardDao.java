package com.example.boardweb.dao.board.UserEmpathyBean;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class GetUserBoardDao extends Dao {
    private GetUserBoardDao() {
        super();
    }
    private static GetUserBoardDao inst = null;
    public static GetUserBoardDao getInst() {
        if (inst == null) inst = new GetUserBoardDao();
        return inst;
    }

    public Object getUserEmpathy(HashMap<String,Object> map) {
        SqlSession sqlSession = sessionFactory.openSession();
        Object obj = null;
        try {
            obj = sqlSession.selectOne("com.example.boardweb.bean.getUserEmpathy",map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return obj;
    }
}