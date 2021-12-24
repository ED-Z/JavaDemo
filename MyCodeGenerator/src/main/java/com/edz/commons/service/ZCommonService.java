package com.edz.commons.service;

import com.edz.commons.mapper.ZCommonMapper;
import com.edz.commons.pojo.ZBaseObject;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface ZCommonService<T extends ZBaseObject> {
    ZCommonMapper<T> getMapper();

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param record
     * @return
     */
    int save(T record);


    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record
     * @return
     */
    int saveNotNull(T record);


    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param key
     * @return
     */
    int deleteByPrimaryKey(Object key);

    /**
     * 根据Example条件删除数据
     * @param example
     * @return
     */
    int deleteByExample(Example example);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record
     * @return
     */
    int update(T record);

    /**
     * 根据主键更新属性不为null的值
     * @param record
     * @return
     */
    int updateNotNull(T record);

    /**
     *	 根据Example条件更新实体`record`包含的全部属性，null值会被更新
     * @param example
     * @param record
     * @return
     */
    int updateByExample(T record,Example example);

    /**
     * 根据Example条件更新实体`record`包含的不是null的属性值
     * @param record
     * @param example
     * @return
     */
    int updateNotNullByExample(T record,Example example);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param key
     * @return
     */
    T selectByPrimaryKey(Object key);

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果则抛出异常，查询条件使用等号
     * @param record
     * @return
     */
    T selectOne(T record);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record
     * @return
     */
    List<T> select(T record);

    /**
     * 根据Example条件进行查询，通过selectProperties方法指定查询列
     * @param example
     * @return
     */
    List<T> selectByExample(Example example);

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     * @return
     */
    List<T> selectAll();

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record
     * @return
     */
    int selectCount(T record);

    /**
     * 根据Example条件进行查询总数
     * @param example
     * @return
     */
    int selectCountByExample(Example example);
}
