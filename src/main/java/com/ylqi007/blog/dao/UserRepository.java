package com.ylqi007.blog.dao;

import com.ylqi007.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String name, String password);
}
