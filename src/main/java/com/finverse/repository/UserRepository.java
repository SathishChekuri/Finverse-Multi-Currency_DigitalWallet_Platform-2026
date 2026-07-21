package com.finverse.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.finverse.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByEmail(String email);

Optional<User> findByMobileNumber(String mobileNumber);

boolean existsByEmail(String email);

boolean existsByMobileNumber(String mobileNumber);
}