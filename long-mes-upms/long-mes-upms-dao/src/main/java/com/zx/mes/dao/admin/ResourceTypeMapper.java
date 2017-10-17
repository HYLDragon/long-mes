package com.zx.mes.dao.admin;

import com.zx.mes.model.admin.ResourceType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResourceType record);

    int insertSelective(ResourceType record);

    ResourceType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResourceType record);

    int updateByPrimaryKey(ResourceType record);

    List<ResourceType> getAll(ResourceType resourceType);
}