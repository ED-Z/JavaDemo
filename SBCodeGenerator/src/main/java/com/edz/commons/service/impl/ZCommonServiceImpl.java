package com.edz.commons.service.impl;

import com.edz.commons.mapper.ZCommonMapper;
import com.edz.commons.pojo.ZBaseObject;
import com.edz.commons.service.ZCommonService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public abstract class ZCommonServiceImpl<T extends ZBaseObject> implements ZCommonService<T> {
    @Override
    public abstract ZCommonMapper<T> getMapper();

    @Override
    public int save(T record) {

        return getMapper().insert(record);
    }

    @Override
    public int saveNotNull(T record) {

        return getMapper().insertSelective(record);
    }

    @Override
    public int delete(T record) {

        return getMapper().delete(record);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {

        return getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int deleteByExample(Example example) {

        return getMapper().deleteByExample(example);
    }

    @Override
    public int update(T record) {

        return getMapper().updateByPrimaryKey(record);
    }

    @Override
    public int updateNotNull(T record) {

        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByExample(T record,Example example) {

        return getMapper().updateByExample(record, example);
    }

    @Override
    public int updateNotNullByExample(T record,Example example) {

        return getMapper().updateByExampleSelective(record, example);
    }

    @Override
    public T selectByPrimaryKey(Object key) {

        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public T selectOne(T record) {

        return getMapper().selectOne(record);
    }

    @Override
    public List<T> select(T record) {

        return getMapper().select(record);
    }

    @Override
    public List<T> selectByExample(Example example) {

        return getMapper().selectByExample(example);
    }

    @Override
    public List<T> selectAll() {

        return getMapper().selectAll();
    }

    @Override
    public int selectCount(T record) {

        return getMapper().selectCount(record);
    }

    @Override
    public int selectCountByExample(Example example) {

        return getMapper().selectCountByExample(example);
    }
}
