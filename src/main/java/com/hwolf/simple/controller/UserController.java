package com.hwolf.simple.controller;

import com.hwolf.simple.entity.User;
import com.hwolf.simple.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @user HWOLF
 * @version create in：17-10-22 下午7:00
 * @descrption
 */
@RestController
@RequestMapping("/home/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.getAsString("user_id");
        String realName = jsonObject.getAsString("real_name");
        String nickName = jsonObject.getAsString("nick_name");
        User user = new User();
        if (user != null) {
            user.setId(Long.valueOf(userId));
        }
        user.setRealName(realName);
        user.setNickName(nickName);
        try {
            this.userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("add wrong");
        }
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void deleteByPrimerId(@PathVariable Long userId, HttpServletRequest httpServletRequest) {
        try {
            this.userService.delete(userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("delete error");
        }
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long userId,@RequestBody JSONObject jsonObject) {
        User user = this.userService.findUser(userId);
        String realName = jsonObject.getAsString("real_name");
        String nickName = jsonObject.getAsString("nick_name");
        user.setRealName(realName);
        user.setNickName(nickName);
        try{
            this.userService.update(user);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("update error");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getUserList(HttpServletRequest httpServletRequest) {
        List<User> userList = this.userService.findUserList();
        Map<String, Object> param = new HashMap<>();
        param.put("total", userList.size());
        param.put("rows", userList);
        return param;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long userId, HttpServletRequest httpServletRequest) {
        User user = this.userService.findUser(userId);
        if (user == null){
            throw new RuntimeException("this user unknown");
        }
        return user;
    }


}
