package com.tms.taskmanagementsystem.repository.userRepository;

import com.tms.taskmanagementsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsername(String name);
    boolean existsByPassword(String password);
}
