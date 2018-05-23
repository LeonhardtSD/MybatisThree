package com.gaozhaoxi.mapper;

import com.gaozhaoxi.entity.User;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Leon
 */
public interface UserMapper {
    public User getUser(Long id);

    public ArrayList<User> getUserByAddressAndName2(Map<String,String> map);
}
