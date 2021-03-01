package com.my.base;

import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/**
 * @author whm
 * @date 2018/8/14
 */
public class BaseQueryAssembly {

    public static Example.Criteria setOneWhere(Example.Criteria criteria, String property, Object value, String searchType){
        if(value != null && !value.equals("")) {
            //精确查询
            if (searchType.equals(SearchTypeEnum.EQ.getValue())) {
                criteria.andEqualTo(property, value);
            }
            //模糊查询
            if (searchType.equals(SearchTypeEnum.LIKE.getValue())) {
                if(value.toString().indexOf("%") == -1){
                    criteria.andLike(property, "%"+value+"%".toString());
                }else{
                    criteria.andLike(property, value.toString());
                }
            }
            //in
            if (searchType.equals(SearchTypeEnum.IN.getValue())) {
                criteria.andIn(property, Arrays.asList(value.toString().split(",")));
            }
            //notIn
            if (searchType.equals(SearchTypeEnum.NOTIN.getValue())) {
                criteria.andNotIn(property, Arrays.asList(value.toString().split(",")));
            }
            //不包含【模糊查询】
            if (searchType.equals(SearchTypeEnum.NOTLIKE.getValue())) {
                criteria.andNotLike(property, value.toString());
            }
            //不等于
            if (searchType.equals(SearchTypeEnum.NQ.getValue())) {
                criteria.andNotEqualTo(property, value);
            }
            //大于
            if (searchType.equals(SearchTypeEnum.GT.getValue())) {
                criteria.andGreaterThan(property, value);
            }
            //大于等于
            if (searchType.equals(SearchTypeEnum.GTE.getValue())) {
                criteria.andGreaterThanOrEqualTo(property, value);
            }
            //小于
            if (searchType.equals(SearchTypeEnum.LT.getValue())) {
                criteria.andLessThan(property, value);
            }
            //小于等于
            if (searchType.equals(SearchTypeEnum.LTE.getValue())) {
                criteria.andLessThanOrEqualTo(property, value);
            }
        }
        return criteria;
    }

    public static Example.Criteria setMoreWhere(Example.Criteria criteria, List<String> property, List<Object> value, List<String> searchType){
        for(int i=0; i<property.size(); i++){
            setOneWhere(criteria, property.get(i), value.get(i), searchType.get(i));
        }
        return criteria;
    }

    public static void setOrderInfo(Example example, String propertyOrderSql){
        String[] propertyOrderAry = propertyOrderSql.split(",");
        for(int i=0; i<propertyOrderAry.length; i++){
            String[] orderAssemblyAry = propertyOrderAry[i].trim().split(" ");
            //有字段名，没有排序类型
            if(orderAssemblyAry.length == 1){
                String property = orderAssemblyAry[0];
                example.orderBy(property).asc();
            }

            //有字段名，有排序类型
            if(orderAssemblyAry.length == 2){
                String property = orderAssemblyAry[0];
                String type = orderAssemblyAry[1];
                if(type.trim().equals("asc")){
                    example.orderBy(property).asc();
                }
                if(type.trim().equals("desc")){
                    example.orderBy(property).desc();
                }
            }
        }
    }

}
