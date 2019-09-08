package com.example.price.Listener;

import com.example.price.service.priceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.price.model.product;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class KafkaListenerservice {

    private priceInfoService pris;


    @Autowired
    public KafkaListenerservice(priceInfoService pris){

        this.pris=pris;
    }

    @KafkaListener(topics = "new_product",groupId = "group_id",containerFactory = "kafkaListenerContainerFactory")
    public void  consume(product product){
        System.out.println(product.toString());
        pris.putPrice(product);

    }

    /*@KafkaListener(topics = "rest",groupId = "group_id",containerFactory = "kafkaListenerContainerFactory")
    public void  Restconsurme(product product){
        System.out.println(product.toString());
        pris.putPrice(product);

    }*/
}
