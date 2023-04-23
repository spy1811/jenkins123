package com.bank.bankapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date tdate;
    private String tdetails;
    private String chqno;
    @Temporal(TemporalType.DATE)
    private Date vdate;
    private String amt;
    private String withdrawl_amt;
    private String deposit_amt;
    private String bal;


}
