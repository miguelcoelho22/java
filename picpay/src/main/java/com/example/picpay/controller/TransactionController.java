package com.example.picpay.controller;

import com.example.picpay.domain.Transaction;
import com.example.picpay.domain.TransactionDto;
import com.example.picpay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto dto) throws Exception {
        Transaction transaction = service.createTransaction(dto);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
