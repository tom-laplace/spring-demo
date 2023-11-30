package com.example.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.models.Loans;
import java.util.List;
import java.time.LocalDate;

public interface LoansRepository extends JpaRepository<Loans, Long> {

    Loans findById(long id);

    Loans findByBookId(long bookId);

    Loans findByUserId(long userId);

    Loans findByBookIdAndUserId(long bookId, long userId);

    List<Loans> findByReturnDateList(LocalDate returnDate);

    List<Loans> findByReturnDateIsNullList();

    List<Loans> findByLoanDateList(LocalDate loanDate);
}
