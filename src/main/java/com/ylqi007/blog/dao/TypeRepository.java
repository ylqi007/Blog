package com.ylqi007.blog.dao;

import com.ylqi007.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findByName(String name);
}
