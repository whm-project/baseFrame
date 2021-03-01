package com.my.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author whm
 * @date 2018/6/12
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T> currentDao;

    /**
     * 新增
     *
     * @param model
     * @return
     */
    @Override
    public int save(T model) {
        return currentDao.insertSelective(model);
    }

    /**
     * 删除
     * @param model
     * @return
     */
    @Override
    public int delete(T model) {
        return currentDao.delete(model);
    }

    /**
     * 根据主键删除
     *
     * @param primaryKey 主键
     * @mbg.generated
     */
    @Override
    public int deleteByPrimaryKey(String primaryKey) {
        return currentDao.deleteByPrimaryKey(primaryKey);
    }

    /**
     * 根据组合主键删除
     * @param primaryKey
     * @param value
     * @param modelClass
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String[] primaryKey, Object[] value, Class<T> modelClass){
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        for (int i = 0; i < primaryKey.length; i++) {
            criteria.andEqualTo(primaryKey[i], value[i]);
        }
        return currentDao.deleteByExample(example);
    }

    /**
     * 根据单字段值删除
     *
     * @param property
     * @param value
     * @param modelClass
     * @return
     */
    @Override
    public int deleteByProperty(String property, Object value, String searchType, Class<T> modelClass) {
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setOneWhere(criteria, property, value, searchType);
        return currentDao.deleteByExample(example);
    }

    /**
     * 根据多字段值删除
     *
     * @param property
     * @param value
     * @param modelClass
     * @return
     */
    @Override
    public int deleteByProperty(String[] property, Object[] value, String[] searchType, Class<T> modelClass) {
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        for (int i = 0; i < property.length; i++) {
            BaseQueryAssembly.setOneWhere(criteria, property[i], value[i], searchType[i]);
        }
        return currentDao.deleteByExample(example);
    }

    /**
     * 更新【所有字段】
     * @param model
     * @return
     */
    @Override
    public int updateByPrimaryKey(T model) {
        return currentDao.updateByPrimaryKey(model);
    }

    /**
     * 更新【有改变的字段】
     * @param model
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(T model) {
        return currentDao.updateByPrimaryKeySelective(model);
    }

    /**
     * 根据单个条件，更新记录【所有字段】
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    @Override
    public int updateInfo(T model, String property, Object value, String searchType, Class<T> modelClass){
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setOneWhere(criteria, property, value, searchType);
        return currentDao.updateByExample(model, example);
    }

    /**
     * 根据多个条件，更新记录【所有字段】
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    @Override
    public int updateInfo(T model, List<String> property, List<Object> value, List<String> searchType, Class<T> modelClass){
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setMoreWhere(criteria, property, value, searchType);
        return currentDao.updateByExample(model, example);
    }

    /**
     * 根据单个条件，更新记录【有改变的字段】
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    @Override
    public int updateInfoSelective(T model, String property, Object value, String searchType, Class<T> modelClass){
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setOneWhere(criteria, property, value, searchType);
        return currentDao.updateByExampleSelective(model, example);
    }

    /**
     * 根据多个条件，更新记录【有改变的字段】
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    @Override
    public int updateInfoSelective(T model, List<String> property, List<Object> value, List<String> searchType, Class<T> modelClass) {
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setMoreWhere(criteria, property, value, searchType);
        return currentDao.updateByExampleSelective(model, example);
    }

    /**
     * 通过主键获取对象
     *
     * @param primaryKey 主键
     * @return HySysTRole
     * @mbg.generated
     */
    @Override
    public T getByPrimaryKey(Object primaryKey) {
        return currentDao.selectByPrimaryKey(primaryKey);
    }

    /**
     * 根据唯一键返回
     *
     * @param uniqueKey
     * @param value
     * @param modelClass
     * @return
     */
    @Override
    public T getByUniqueKey(String uniqueKey, Object value, Class<T> modelClass) {
        Example example = new Example(modelClass);
        example.createCriteria().andEqualTo(uniqueKey, value);
        return currentDao.selectOneByExample(example);
    }

    /**
     * 根据组合唯一键返回
     * @param uniqueKeys
     * @param values
     * @param modelClass
     * @return
     */
    @Override
    public T getByUnionUniqueKey(String[] uniqueKeys, Object[] values, Class<T> modelClass) {
        if (uniqueKeys != null && uniqueKeys.length > 0 && values != null && values.length > 0) {
            Example example = new Example(modelClass);
            Example.Criteria criteria = example.createCriteria();
            for (int i = 0; i < uniqueKeys.length; i++) {
                criteria.andEqualTo(uniqueKeys[i], values[i]);
            }
            return currentDao.selectOneByExample(example);
        }
        return null;
    }

    /**
     * 根据单个条件，返回列表信息
     *
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    @Override
    public List<T> findInfo(String property, Object value, String searchType, String orderSql, Class<T> modelClass) {
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setOneWhere(criteria, property, value, searchType);
        if(orderSql.length() > 0){
            BaseQueryAssembly.setOrderInfo(example, orderSql);
        }
        return currentDao.selectByExample(example);
    }

    /**
     * 根据多个条件，返回列表信息
     *
     * @param property
     * @param value
     * @param searchType
     * @param modelClass
     * @return
     */
    @Override
    public List<T> findInfo(List<String> property, List<Object> value, List<String> searchType, String orderSql, Class<T> modelClass) {
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setMoreWhere(criteria, property, value, searchType);
        if(orderSql.length() > 0){
            BaseQueryAssembly.setOrderInfo(example, orderSql);
        }
        return currentDao.selectByExample(example);
    }

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
    @Override
    public PageInfo<T> findPageInfo(String property, Object value, String searchType, String orderSql, Class<T> modelClass, int pageNumber, int pageSize) {
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setOneWhere(criteria, property, value, searchType);
        if(orderSql.length() > 0){
            BaseQueryAssembly.setOrderInfo(example, orderSql);
        }
        PageHelper.startPage(pageNumber, pageSize);
        List<T> pageResult=currentDao.selectByExample(example);
        return new PageInfo<T>(pageResult);
    }

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
    @Override
    public PageInfo<T> findPageInfo(List<String> property, List<Object> value, List<String> searchType, String orderSql, Class<T> modelClass, int pageNumber, int pageSize) {
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        BaseQueryAssembly.setMoreWhere(criteria, property, value, searchType);
        if(orderSql.length() > 0){
            BaseQueryAssembly.setOrderInfo(example, orderSql);
        }
        PageHelper.startPage(pageNumber, pageSize);
        List<T> pageResult=currentDao.selectByExample(example);
        return new PageInfo<T>(pageResult);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<T> findAll() {
        return currentDao.selectAll();
    }

}
