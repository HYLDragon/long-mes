package com.zx.mes.dao.admin;

import com.zx.mes.model.admin.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> getAll(Resource resource);

    List<Resource> getAllWithIds(List<String> ids);

    List<Resource> getResourceWithType(Resource resource);

    List<Resource> getResourceWithTypeUser(Resource resource);
}