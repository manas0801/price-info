package com.example.price.dao.impl;
import com.example.price.dao.mapper.PriceInfoMapper;
import com.example.price.dao.priceInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;
import com.example.price.model.product;
import com.example.price.dao.mapper.priceMapper;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;


@Repository
public class priceInfoDaoImpl implements priceInfoDao {


   @Autowired
    private JdbcTemplate jdbc;

   @Autowired
   private PriceInfoMapper pim;

    public product getPriceInfo(String name) {

        return jdbc.queryForObject("select * from PriceInfo where Name=?", new priceMapper(), name);
    }

    public List<product> getPriceInfoAll() {

        //return jdbc.query("select * from PriceInfo", new priceMapper());
       return pim.findAll();
    }

    @Override
    public product putPriceInfo(product p) {


        product p1=null;
       try{
         p1 =
                jdbc.queryForObject("select * from PriceInfo where Name=?", new priceMapper(), p.getName()); }
           catch (EmptyResultDataAccessException e) {
             p1 =null;}


        if (p1 == null) {

            KeyHolder kh = new GeneratedKeyHolder();
            jdbc.update(c -> {
                PreparedStatement ps = c.prepareStatement("Insert into PriceInfo (Name,Price) values (?,?)",
                        new String[]{"id"});
                ps.setString(1, p.getName());
                ps.setFloat(2, p.getPrice());
                return ps;
            }, kh);

            return p;

        } else {
            jdbc.update("update PriceInfo set price = ? where name =?", new Object[]{p.getPrice(),p.getName()},
                    new int[]{Types.DOUBLE,Types.VARCHAR});
           return p;
        }
    }

}