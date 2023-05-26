package com.example.boardweb.dao.board;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class SelectListlDao extends Dao {
    private SelectListlDao() {
        super();
    }
    private static SelectListlDao inst = null;
    public static SelectListlDao getInst() {
        if(inst == null) inst = new SelectListlDao();
        return inst;
    }

    public List<Object> selectList(HashMap<String,Object>map) {
        SqlSession sqlSession = sessionFactory.openSession();

        List<Object> list = null;
        try {
            list=sqlSession.selectList("com.example.boardweb.bean.select",map);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


        return list;
    }
}
