package com.example.boardweb.dao;

import com.example.boardweb.config.SqlSessionManager;
import org.apache.ibatis.session.SqlSessionFactory;

public abstract class Dao {
    protected SqlSessionFactory sessionFactory = null;
    protected Dao() {
        sessionFactory = SqlSessionManager.getSqlSessionFactory();
    }
}
