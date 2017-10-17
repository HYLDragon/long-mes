package com.zx.mes.dao.admin;

import com.zx.mes.model.admin.Bug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugMapper {
    int deleteByPrimaryKey(String id);

    int insert(Bug record);

    int insertSelective(Bug record);

    Bug selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Bug record);

    int updateByPrimaryKey(Bug record);

    long getCount(Bug bug);

    List<Bug> getAll(Bug bug);

    List<Bug> getAllWithBugType(Bug bug);

}