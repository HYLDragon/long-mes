package com.zx.mes.dao.admin;

import com.zx.mes.model.admin.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    long getCount(User user);

    List<User> sum(User user);

    List<User> getAll(User user);

    List<User> getAllWithRole(User user);

    User  login(User user);

    List<User> getUser(User user);

}