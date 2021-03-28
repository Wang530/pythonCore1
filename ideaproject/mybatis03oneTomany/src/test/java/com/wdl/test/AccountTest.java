package com.wdl.test;

import com.wdl.dao.IAccountDao;
import com.wdl.domain.Account;
import com.wdl.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accontDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory fa = new SqlSessionFactoryBuilder().build(in);
        sqlSession = fa.openSession();
        accontDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        List<Account > account = accontDao.findAll();
        for (Account account1 : account) {
            System.out.println(account1);
            System.out.println(account1.getUser());
        }

    }

    @Test
    public void testFindAllAccountUser() {

        List<AccountUser> accountUsers = accontDao.findAllAccount();
        for (Account accountuser : accountUsers) {
            System.out.println(accountuser);
        }

    }









}
