package com.example.onlinestore.orderorderline.orderorderline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderOrderlineApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(OrderOrderlineApplication.class, args);
	}
}
