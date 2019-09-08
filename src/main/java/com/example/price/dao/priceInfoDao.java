package com.example.price.dao;

import com.example.price.model.product;
import java.util.List;

public interface priceInfoDao {
    public product getPriceInfo(String name);
    public List<product> getPriceInfoAll();
    public product putPriceInfo(product p);

}
