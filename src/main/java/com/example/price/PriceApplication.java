package com.example.price;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import com.example.price.model.product;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.price"})
@MapperScan("com.example.price.dao.mapper")
@EnableKafka
public class PriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceApplication.class, args);
	}




	@Bean
	public ConsumerFactory<String,product> consumerFactory(){


		JsonDeserializer<product> jsonDeserializer = new JsonDeserializer(product.class);
		jsonDeserializer.addTrustedPackages("*");
		//jsonDeserializer.setRemoveTypeHeaders(false);
		jsonDeserializer.setUseTypeMapperForKey(true);

		Map<String,Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, jsonDeserializer);


		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),jsonDeserializer);
	}


	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,product> kafkaListenerContainerFactory(){

		ConcurrentKafkaListenerContainerFactory<String,product> factory = new ConcurrentKafkaListenerContainerFactory<String, product>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
