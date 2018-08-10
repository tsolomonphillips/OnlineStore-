package com.example.onlinestore.accountaddress.accountaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountAddressApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(AccountAddressApplication.class, args);
	}
}
