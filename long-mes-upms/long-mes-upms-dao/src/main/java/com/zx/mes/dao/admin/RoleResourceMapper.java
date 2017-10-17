package com.zx.mes.dao.admin;

import com.zx.mes.model.admin.RoleResourceKey;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleResourceMapper {
    int deleteByPrimaryKey(RoleResourceKey key);

    int deleteByPrimaryRoleResourceKey(RoleResourceKey roleResourceKey);

    int insert(RoleResourceKey record);

    int insertSelective(RoleResourceKey record);
}