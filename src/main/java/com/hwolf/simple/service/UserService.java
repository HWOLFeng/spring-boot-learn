package com.hwolf.simple.service;

import com.hwolf.simple.entity.User;

import java.util.List;

/**
 * @User HWOLF
 * @version create in：17-10-22 下午6:57
 * @descrption
 */
public interface UserService {
    int add(User user);
    int update(User user);
    int delete(Long id);
    User findUser(Long id);
    List<User> findUserList();
}
