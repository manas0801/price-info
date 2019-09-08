package com.example.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.price.model.product;
import com.example.price.service.priceInfoService;
import org.springframework.http.HttpStatus;
import java.util.List;

import java.sql.PreparedStatement;

@RestController
@RequestMapping("/price")
public class priceController {

private priceInfoService pris;


@Autowired
public priceController(priceInfoService pris){

    this.pris=pris;
}


@GetMapping("/{product}")
    public product getPrice(@PathVariable(name="product") String product){

        return  pris.getPrice(product);


    }

    @GetMapping("/")
    public List <product> getPriceAll(){

        return  pris.getPriceAll();


    }


    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public product putPrice (@RequestBody product p) throws Exception

        {
            if (p.getName().equals(new String("Book"))) {
            throw new Exception();}

            return pris.putPrice(p);
        }
}


