package com.example.picpay.service;

import com.example.picpay.domain.*;
import com.example.picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validarTransacao(User sender, BigDecimal amount) throws Exception {

        if(sender.getUserType() == UserType.LOJISTA){
            throw new Exception("lojistas so podem receber transacoes");
        }
        if(sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("dinheiro insuficiente para a transaçao");
        }

    }
    public User saveUser(UserDto dto) {
        return repository.save(new User(dto));
    }

    public List<User> showUsers() {
        return repository.findAll();
    }

    public User findUserById(Long id) {
        return repository.findUserById(id);
    }

    public void savaUser(User user){
        repository.save(user);
    }
}
