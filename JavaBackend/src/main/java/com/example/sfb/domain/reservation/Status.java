package com.example.sfb.domain.reservation;

import lombok.*;

import javax.persistence.*;

@Entity(name = "STATUS")
@Table(name = "STATUS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Status {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;
}
