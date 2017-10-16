package com.zx.mes.dao.mes;

import com.zx.mes.model.mes.CareType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CareTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(CareType record);

    int insertSelective(CareType record);

    CareType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CareType record);

    int updateByPrimaryKey(CareType record);

    List<CareType> getAll(CareType careType);

}