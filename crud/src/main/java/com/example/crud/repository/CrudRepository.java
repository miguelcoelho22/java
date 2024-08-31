package com.example.crud.repository;

import com.example.crud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<User, Long> {
}
