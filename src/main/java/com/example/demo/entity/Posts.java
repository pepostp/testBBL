package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

}
