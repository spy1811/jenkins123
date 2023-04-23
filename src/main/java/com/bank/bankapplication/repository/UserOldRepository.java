package com.bank.bankapplication.repository;

import com.bank.bankapplication.entity.UserOld;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOldRepository extends JpaRepository<UserOld,Integer> {

    UserOld findByUsername(String username);
}
