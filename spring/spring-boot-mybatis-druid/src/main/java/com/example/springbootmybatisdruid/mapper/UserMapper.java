package com.example.springbootmybatisdruid.mapper;


import com.example.springbootmybatisdruid.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_user;")
    List<User> selectAll();


}
