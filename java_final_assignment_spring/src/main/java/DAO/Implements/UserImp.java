package DAO.Implements;

import DAO.Domain.User;
import DAO.Interface.UserDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserImp implements UserDAOInterface {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }



    @Override
    public boolean create(User user){
        return jdbcTemplate.update("insert into ylbUserInfo(userName, password) value (?,?)",
                user.getUserName(), user.getPassword()) != 0;

    }

    @Override
    public boolean ifUserNameExist(String userName) {
        List<User> list = jdbcTemplate.query("select userName,passWord from ylbUserInfo where userName= ?",
                new Object[]{userName},
                new UserMapper());
        return list.size()!=0;
    }

    @Override
    public boolean checkAccountAndPassword(User user) {
        List<User> list = jdbcTemplate.query("select userName,passWord from ylbUserInfo " +
                        "where userName = ? and password = ?",
                new Object[]{user.getUserName(),user.getPassword()},
                new UserMapper());
        return list.size()!=0;
    }

    public static final class UserMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User e = new User();
            e.setUserName(rs.getString("userName"));
            e.setPassword(rs.getString("password"));
            return e;
        }
    }
}
