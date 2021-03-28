package com.wdl.dao.impl;

import com.wdl.dao.IUserDao;
import com.wdl.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.wdl.dao.IUserDao.findAll");
        return users;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.wdl.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("com.wdl.dao.IUserDao.updateUser",user);
        session.commit();
        session.close();
    }

    public void deleteUser(Integer id) {
        SqlSession session = factory.openSession();
        session.delete("com.wdl.dao.IUserDao.deleteUser",id);
        session.commit();
        session.close();
    }

    public User findById(Integer id) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("com.wdl.dao.IUserDao.findById",id);
        //session.commit();
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.wdl.dao.IUserDao.findByName", username);
        session.commit();
        session.close();
        return users;
    }

    public int findTotal() {
        SqlSession session = factory.openSession();
        Integer count = session.selectOne("com.wdl.dao.IUserDao.findTotal");
//        session.commit();
        session.close();
        return count;
    }
}
