package com.example.springdemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.dto.LoansDTO;
import com.example.springdemo.models.Loans;
import com.example.springdemo.services.LoansService;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoansController {

    private final LoansService loansService;

    public LoansController(LoansService loansService) {
        this.loansService = loansService;
    }

    @GetMapping
    public ResponseEntity<List<Loans>> getAllLoans() {
        return ResponseEntity.ok(loansService.findAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loans> getLoansById(@PathVariable Long id) {
        Loans loans = loansService.getLoansById(id);
        return ResponseEntity.ok(loans);
    }

    @PostMapping
    public ResponseEntity<Loans> addLoans(@RequestBody LoansDTO loans) {
        Loans savedLoans = loansService.addLoans(loans);
        return ResponseEntity.ok(savedLoans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoans(@PathVariable Long id) {
        loansService.deleteLoans(id);
        return ResponseEntity.ok().build();
    }
}