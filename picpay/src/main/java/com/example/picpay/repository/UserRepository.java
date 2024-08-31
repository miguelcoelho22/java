package com.example.picpay.repository;

import com.example.picpay.domain.User;
import com.example.picpay.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

}
