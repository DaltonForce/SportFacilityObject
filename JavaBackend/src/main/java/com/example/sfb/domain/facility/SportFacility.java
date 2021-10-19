package com.example.sfb.domain.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "SPORT_OBJECT")
@Table(name = "SPORT_OBJECT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SportFacility implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "SPORT_ID")
    private int sportId;

    @Column(name = "SPORT_NAME")
    private String sport;
}
