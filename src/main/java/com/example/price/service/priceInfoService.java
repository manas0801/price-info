package com.example.price.service;
import com.example.price.model.product;
import java.util.List;

public interface priceInfoService {

    public product getPrice(String name);
    public List <product> getPriceAll();
    public product putPrice(product p);
}
