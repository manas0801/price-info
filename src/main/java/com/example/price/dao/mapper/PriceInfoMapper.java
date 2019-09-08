package com.example.price.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.price.model.product;

import java.util.List;


@Mapper
public interface PriceInfoMapper {

    @Select("select * from PriceInfo")
    public List<product> findAll();

}
