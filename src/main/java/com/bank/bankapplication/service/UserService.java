package com.bank.bankapplication.service;

import com.bank.bankapplication.entity.UserOld;
import com.bank.bankapplication.repository.UserOldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserOldRepository userRepository;

    public UserOld saveUser(UserOld user){
        return userRepository.save(user);
    }

    public List<UserOld> getAll(){
        return userRepository.findAll();
    }

    public UserOld getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public UserOld updateUser(UserOld user){
        UserOld existing = userRepository.findById(user.getId()).orElse(null);
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());

        return userRepository.save(existing);
    }

    public UserOld getUsername(String username){
        return userRepository.findByUsername(username);
    }

}
