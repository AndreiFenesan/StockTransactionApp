package com.example.stocktransactionapp.datasource.security.repository;

import com.example.stocktransactionapp.datasource.security.model.BasicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicUserRepository extends JpaRepository<BasicUser, Integer> {
}
