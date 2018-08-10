package com.example.onlinestore.accountaddress.accountaddress.repository;

import com.example.onlinestore.accountaddress.accountaddress.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>
{

}
