package com.zx.mes.dao.admin;

import com.zx.mes.model.admin.BugType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(BugType record);

    int insertSelective(BugType record);

    BugType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BugType record);

    int updateByPrimaryKey(BugType record);

    List<BugType> getAll(BugType bugType);
}