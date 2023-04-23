package com.bank.bankapplication.service;

import com.bank.bankapplication.entity.Transaction;
import com.bank.bankapplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> fetAll(){
        return repository.findAll();
    }

    public List<Transaction> findByDate(Date tdate){
        return repository.findAllByTdate(tdate);
    }

    public List<Transaction> findByDataBetween(Date tdate,Date edate){

        return repository.findAllByTdateBetween(tdate,edate);
    }

    public List<Transaction> findLast(){
        return repository.findTopByOrderByIdDesc();
    }

    /*public List<Transaction> findByDateBelow(Date tdate){
        return  repository.findAllWithTdateBefore(tdate);
    }*/


}
