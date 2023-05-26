package com.example.boardweb.dao.board;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryListDao extends Dao {
    private CategoryListDao() {
        super();
    }

    private static CategoryListDao inst = null;
    public static CategoryListDao getInst() {
        if(inst == null) inst = new CategoryListDao();
        return inst;
    }
    public List<Object> getCategoryList() {
        SqlSession sqlSession = sessionFactory.openSession();

        List<Object> list = null;
        try {
            list=sqlSession.selectList("com.example.boardweb.bean.selectCategory");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
