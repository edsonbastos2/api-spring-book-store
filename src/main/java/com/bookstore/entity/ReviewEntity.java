package com.bookstore.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_review")
public class ReviewEntity implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Long id;

    @Column(name = "name", nullable = false)
    private String comment;

    public ReviewEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
