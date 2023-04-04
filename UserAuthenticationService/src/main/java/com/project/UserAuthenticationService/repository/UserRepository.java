package com.project.UserAuthenticationService.repository;

import com.project.UserAuthenticationService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
//    User findUserByEmailAndPassword(String email, String password);

      User findByResetPasswordToken(String token);
      User findByEmail(String email);
}
