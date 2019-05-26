package com.example.demo.dao;

import com.example.demo.model.PO.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Insert("insert into flash(username,password) values(#{username},#{password})")
    void addUser(User user);

    @Select("select * from flash where username=#{username}")
    User getUserByName(String username);

    @Delete("delete from flash where username=#{username}")
    void deleteUser(String user);

    @Update("update flash set password=#{password} where username=#{username}")
    void updateUser(User user);
}
