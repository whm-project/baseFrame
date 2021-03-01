package com.my.base;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author whm
 * @date 2018/6/12
 */
public interface BaseService<T> {

    /**
     * 新增
     * @param model
     * @return
     */
    int save(T model);



    /**
     * 删除
     * @param model
     * @return
     */
    int delete(T model);

    /**
     * 根据主键删除
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey);

    /**
     * 根据组合主键删除
     * @param primaryKey
     * @param value
     * @param modelClass
     * @return
     */
    int deleteByPrimaryKey(String[] primaryKey, Object[] value, Class<T> modelClass);

    /**
     * 根据单字段值删除
     * @param property
     * @param value
     * @param modelClass
     * @return
     */
    int deleteByProperty(String property, Object value, String searchType, Class<T> modelClass);

    /**
     * 根据多字段值删除
     * @param property
     * @param value
     * @param modelClass
     * @return
     */
    int deleteByProperty(String[] property, Object[] value, String[] searchType, Class<T> modelClass);



    /**
     * 通过主键获取对象
     *
     * @param primaryKey 主键
     * @return HySysTRole
     * @mbg.generated
     */
    T getByPrimaryKey(Object primaryKey);

    /**
     * 根据唯一键返回
     * @param uniqueKey
     * @param value
     * @param modelClass
     * @return
     */
    T getByUniqueKey(String uniqueKey, Object value, Class<T> modelClass);

    /**
     * 根据组合唯一键返回
     * @param uniqueKeys
     * @param values
     * @param modelClass
     * @return
     */
    T getByUnionUniqueKey(String[] uniqueKeys, Object[] values, Class<T> modelClass);

    /**
     * 根据单个条件，返回列表信息
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    List<T> findInfo(String property, Object value, String searchType, String orderSql, Class<T> modelClass);

    /**
     * 根据多个条件，返回列表信息
     * @param property
     * @param value
     * @param modelClass
     * @param searchType
     * @return
     */
    List<T> findInfo(List<String> property, List<Object> value, List<String> searchType, String orderSql, Class<T> modelClass);

    /**
     * 根据单个条件，返回分页列表信息
     * @param property
     * @param value
     * @param searchType
     * @param orderSql
     * @param modelClass
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<T> findPageInfo(String property, Object value, String searchType, String orderSql, Class<T> modelClass, int pageNumber, int pageSize);

    /**
     * 根据多个条件，返回分页列表信息
     * @param property
     * @param value
     * @param searchType
     * @param orderSql
     * @param modelClass
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<T> findPageInfo(List<String> property, List<Object> value, List<String> searchType, String orderSql, Class<T> modelClass, int pageNumber, int pageSize);

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();



    /**
     * 更新【所有字段】
     * @param model
     * @return
     */
    int updateByPrimaryKey(T model);

    /**
     * 更新【有改变的字段】
     * @param model
     * @return
     */
    int updateByPrimaryKeySelective(T model);

    /**
     * 根据单个条件，更新记录【所有字段】
     * @param model
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    int updateInfo(T model, String property, Object value, String searchType, Class<T> modelClass);

    /**
     * 根据多个条件，更新记录【所有字段】
     * @param model
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    int updateInfo(T model, List<String> property, List<Object> value, List<String> searchType, Class<T> modelClass);

    /**
     * 根据单个条件，更新记录【有改变的字段】
     * @param model
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    int updateInfoSelective(T model, String property, Object value, String searchType, Class<T> modelClass);

    /**
     * 根据多个条件，更新记录【有改变的字段】
     * @param model
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    int updateInfoSelective(T model, List<String> property, List<Object> value, List<String> searchType, Class<T> modelClass);
}
