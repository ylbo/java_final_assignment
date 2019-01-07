package DAO.Implements;

import DAO.Domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:RunConfig.xml")
public class UserImpTest {

    @Autowired
    private UserImp userImp;

    @Test(expected = org.springframework.dao.DuplicateKeyException.class)
    public void create() {
        User user = new User();
        user.setUserName("root");
        user.setPassword("123456");
        assert(userImp.create(user));
        userImp.create(user);
    }

    @Test
    public void ifUserNameExist() {
        assert userImp.ifUserNameExist("root");
    }

    @Test
    public void checkAccountAndPassword() {
        User user =new User();
        user.setUserName("root");
        user.setPassword("123456");
        assert userImp.checkAccountAndPassword(user);
    }
}