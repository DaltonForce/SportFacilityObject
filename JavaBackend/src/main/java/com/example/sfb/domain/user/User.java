package com.example.sfb.domain.user;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "USERS")
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "AGE")
    private int age;

    @Column(name = "ROLE")
    private String role;
}
