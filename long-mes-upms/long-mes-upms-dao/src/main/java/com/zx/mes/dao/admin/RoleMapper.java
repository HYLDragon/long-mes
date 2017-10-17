package com.zx.mes.dao.admin;

import com.zx.mes.model.admin.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    long getCount(Role role);

    List<Role> getAll(Role role);

    List<Role> getAllWithRource(Role role);

    List<Role> getAllWithRource2(List<String> ids);

    List<Role> getAllWithRourceByRoleIds(List<String> ids);

    List<Role> getAllWithUserId(Role role);
}