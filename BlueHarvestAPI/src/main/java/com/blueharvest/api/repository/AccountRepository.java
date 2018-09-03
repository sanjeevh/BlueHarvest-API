package com.blueharvest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueharvest.api.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}

