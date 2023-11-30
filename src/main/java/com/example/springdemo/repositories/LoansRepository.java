package com.example.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.models.Loans;

public interface LoansRepository extends JpaRepository<Loans, Long> {

    Integer countAllLoansByUserId(Long userId);
}
