package com.wdl.test;

import com.wdl.dao.IAccountDao;
import com.wdl.dao.IUserDao;
import com.wdl.domain.Account;
import com.wdl.domain.AccountUser;
import com.wdl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory fa = new SqlSessionFactoryBuilder().build(in);
        sqlSession = fa.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("每个用户信息");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }

/*    @Test
    public void testFindAllAccountUser() {

        List<AccountUser> accountUsers = accontDao.findAllAccount();
        for (Account accountuser : accountUsers) {
            System.out.println(accountuser);
        }

    }*/









}
