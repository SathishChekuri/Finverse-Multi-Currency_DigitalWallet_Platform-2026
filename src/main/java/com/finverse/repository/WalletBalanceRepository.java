package com.finverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finverse.entity.User;

public interface WRepository extends JpaRepository<User, Long> {

}