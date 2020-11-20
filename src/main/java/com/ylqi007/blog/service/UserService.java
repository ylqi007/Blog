package com.ylqi007.blog.service;

import com.ylqi007.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
