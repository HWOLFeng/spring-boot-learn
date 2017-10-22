package com.hwolf.simple.service.impl;

import com.hwolf.simple.dao.UserDao;
import com.hwolf.simple.entity.User;
import com.hwolf.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HWOLF
 * @version create in：17-10-22 下午6:57
 * @descrption
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    public int add(User user) {
        return this.userDao.add(user);
    }

    public int update(User user) {
        return this.userDao.update(user);
    }

    public int delete(Long id) {
        return this.userDao.delete(id);
    }

    public User findUser(Long id) {
        return this.userDao.findUser(id);
    }

    public List<User> findUserList() {
        return this.userDao.findUsers();
    }
}
