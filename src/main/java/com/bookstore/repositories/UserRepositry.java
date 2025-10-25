package com.bookstore.repositories;

import com.bookstore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositry extends JpaRepository<UserEntity, UUID> {
}
