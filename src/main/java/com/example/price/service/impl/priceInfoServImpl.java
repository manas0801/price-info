package com.example.price.service.impl;
import com.example.price.Aop.LogExecutionTime;
import  com.example.price.service.priceInfoService;
import com.example.price.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.price.dao.priceInfoDao;

import java.util.List;

@Service
public class priceInfoServImpl implements priceInfoService   {


    @Autowired
    private priceInfoDao gpidao;

    @Override
    @LogExecutionTime
    public product getPrice(String name) {

        return gpidao.getPriceInfo(name);
    }

    @Override
    @LogExecutionTime
    public List<product> getPriceAll() {

        return gpidao.getPriceInfoAll();
    }

    @Override
    @LogExecutionTime
    public product putPrice(product p) {

        return gpidao.putPriceInfo(p);
    }
}
