package com.data.session02.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "theaters")
@Data
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "theater")
    private List<ScreenRoom> screenRooms;
}
