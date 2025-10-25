package com.bookstore.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_publisher")
public class PublisherEntity implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publisher")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public PublisherEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
