package com.example.springdemo.services.loans;

import com.example.springdemo.dto.LoansDTO;
import com.example.springdemo.models.Loans;

import java.util.List;

public interface ILoansService {
    List<Loans> findAllLoans();

    Loans getLoansById(Long id);

    Loans addLoans(LoansDTO loans);

    void deleteLoans(Long id);

    List<Loans> findAllLoansByUserId(Long userId);
}
