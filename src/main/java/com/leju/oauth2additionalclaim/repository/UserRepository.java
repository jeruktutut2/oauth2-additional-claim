package com.leju.oauth2additionalclaim.repository;

import com.leju.oauth2additionalclaim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
