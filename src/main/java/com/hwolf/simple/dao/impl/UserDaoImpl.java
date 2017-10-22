package com.hwolf.simple.dao.impl;

import com.hwolf.simple.dao.UserDao;
import com.hwolf.simple.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HWOLF
 * @version create in：17-10-22 下午5:52
 * @descrption
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(User user) {
        return jdbcTemplate.update("insert into t_author(real_name, nick_name) values(?, ?)",
                user.getRealName(), user.getNickName());
    }

    public int update(User user) {
        return jdbcTemplate.update("UPDATE t_author SET real_name=?,nick_name=? WHERE id=?",
                new Object[]{user.getRealName(), user.getNickName(), user.getId()});
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM t_author WHERE id=?",id);
    }

    public User findUser(Long id) {
        List<User>list = jdbcTemplate.query("SELECT * FROM t_author WHERE id=?",new Object[]{id},new BeanPropertyRowMapper(User.class));
        if (list!=null && list.size()>0){
            User user = list.get(0);
            return user;
        }else {
            return null;
        }
    }

    public List<User> findUsers() {
        List<User> list = jdbcTemplate.query("SELECT * FROM t_author ",new Object[]{},new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
}
