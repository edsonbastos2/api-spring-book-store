package com.bookstore.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_author")
public class AuthorEntity implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Long Id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    public AuthorEntity() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
