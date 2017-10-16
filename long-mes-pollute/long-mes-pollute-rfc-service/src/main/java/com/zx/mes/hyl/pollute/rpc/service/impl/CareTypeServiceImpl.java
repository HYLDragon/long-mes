package com.zx.mes.hyl.pollute.rpc.service.impl;

import com.zx.mes.dao.mes.CareTypeMapper;
import com.zx.mes.hyl.pollute.service.CareTypeServiceI;
import com.zx.mes.model.mes.CareType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
public class CareTypeServiceImpl implements CareTypeServiceI {

    @Autowired
    private CareTypeMapper careTypeMapper;


    @Cacheable(value = "careTypeServiceCache", key = "'careTypeList'")
    public List<CareType> getCareTypeList() {
        return careTypeMapper.getAll(new CareType());
    }
}
