package com.example.onlinestore.accountaddress.accountaddress.repository;

import com.example.onlinestore.accountaddress.accountaddress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>
{
}
