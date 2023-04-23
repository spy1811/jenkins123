package com.bank.bankapplication.repository;

import com.bank.bankapplication.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findAllByTdate(Date tdate);

    List<Transaction> findAllByTdateBetween(Date tdate,Date edate);

    List<Transaction> findTopByOrderByIdDesc();
    /*@Query("select  from transaction  where tdate <= :tdate")
    List<Transaction> findAllWithTdateBefore(@Param("tdate") Date tdate);*/


}
