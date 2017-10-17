package com.zx.mes.dao.admin;

import com.zx.mes.model.admin.UserRoleKey;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int deleteByPrimarySelectUserRole(UserRoleKey userRoleKey);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    int selectByPrimaryKey(UserRoleKey userRoleKey);
}