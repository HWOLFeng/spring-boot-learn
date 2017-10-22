package com.hwolf.simple.dao;

import com.hwolf.simple.entity.User;

import java.util.List;

/**
 * @author HWOLF
 * @version create in：17-10-22 下午5:51
 * @descrption
 */
public interface UserDao {
    int add(User user);
    int update(User user);
    int delete(Long id);
    User findUser(Long id);
    List<User> findUsers();
}
