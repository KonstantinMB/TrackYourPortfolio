package com.konstantinmb.trackyourportfolio.repository;

import com.konstantinmb.trackyourportfolio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
