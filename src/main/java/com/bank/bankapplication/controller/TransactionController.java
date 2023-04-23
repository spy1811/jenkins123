package com.bank.bankapplication.controller;

import com.bank.bankapplication.entity.Transaction;
import com.bank.bankapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class TransactionController {


    private final TransactionService service;

    @CrossOrigin(origins= {"http://localhost:3000","http://localhost:8080"})
    @GetMapping("/getTransaction")
    public List<Transaction> getTransaction(){
        return service.fetAll();
    }
}
