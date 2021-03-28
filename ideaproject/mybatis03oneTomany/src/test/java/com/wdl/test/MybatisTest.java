package com.wdl.test;

import com.wdl.dao.IUserDao;
import com.wdl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
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
            System.out.println(user);
        }

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("wangwu");
        user.setAddress("上海市外滩");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("before"+user);
        userDao.saveUser(user);
        System.out.println("after"+user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(4);
        user.setUsername("zhangsi");
        user.setAddress("上海市内滩");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);

    }

    @Test
    public void testDelete() {
        userDao.deleteUser(3);

    }

    @Test
    public void testfindOne() {
        User byId = userDao.findById(4);
        System.out.println(byId);

    }

    @Test
    public void testfindByName() {
        List<User> byName = userDao.findByName("%zhang%");
        System.out.println(byName);
        for (User user : byName) {
            System.out.println(user);
        }
    }

    @Test
    public void testfindTotal() {
        System.out.println(userDao.findTotal());

    }
  //  @Test
//    public void testfindByVo() {
//        QueryVo queryVo = new QueryVo();
//        User user1 = new User();
//        user1.setUsername("%zhang%");
//        queryVo.setUser(user1);
//        List<User> users = userDao.findUserByVo(queryVo);
//        System.out.println(users);
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
}
