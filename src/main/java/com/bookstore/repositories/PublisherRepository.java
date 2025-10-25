package com.bookstore.repositories;

import com.bookstore.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
}
