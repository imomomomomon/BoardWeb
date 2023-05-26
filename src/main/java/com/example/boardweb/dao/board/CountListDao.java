package com.example.boardweb.dao.board;

import com.example.boardweb.dao.Dao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class CountListDao extends Dao {
    private CountListDao() {
        super();
    }

    private static CountListDao inst = null;
    public static CountListDao getInst() {
        if(inst == null) inst = new CountListDao();
        return inst;
    }

    public int getCountList(HashMap<String,Object> map){
        SqlSession sqlSession = sessionFactory.openSession();

        int count = 0;
        try {
            count=sqlSession.selectOne("com.example.boardweb.bean.count",map);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return count;
    }
}
