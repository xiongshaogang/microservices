package com.northbrain.common.security.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.northbrain.common.security.model.po.AccessControlHisPO;

@Mapper
@Component(value="accessControlHisPOMapper")
public interface AccessControlHisPOMapper
{
    int deleteByPrimaryKey(Integer recordId) throws Exception;

    int insert(AccessControlHisPO record) throws Exception;

    int insertSelective(AccessControlHisPO record) throws Exception;

    AccessControlHisPO selectByPrimaryKey(Integer recordId) throws Exception;

    int updateByPrimaryKeySelective(AccessControlHisPO record) throws Exception;

    int updateByPrimaryKey(AccessControlHisPO record) throws Exception;
}