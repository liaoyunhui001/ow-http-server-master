package com.rst.ow.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hujia on 2016/11/16.
 */
@Mapper
public interface UserDao {

    /**
     * 插入用户
     * @return 插入的行数
     */
    @Insert("INSERT IGNORE INTO user (name, phone, email, industry, type) " +
            "        VALUES (#{name}, #{phone}, #{email}, #{industry}, #{type})")
    boolean insertUser(@Param("name") String name, @Param("email") String email
            , @Param("phone") String phone, @Param("industry") String industry, @Param("type") String type);
}
