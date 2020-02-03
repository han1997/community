package com.hhy.community.community.mapper;

import com.hhy.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author hhy1997
 * 2020/1/21
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatar})")
    void insert(User user);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer creator);
}
