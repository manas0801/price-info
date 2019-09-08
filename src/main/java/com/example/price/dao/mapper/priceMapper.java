package com.example.price.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.example.price.model.product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class priceMapper implements RowMapper<product> {

    @Override
    public product mapRow(ResultSet resultSet, int i) throws SQLException{

        product p = new product();
        p.setName(resultSet.getString("Name"));
        p.setPrice(resultSet.getFloat("Price"));
        return p;
    }
}
