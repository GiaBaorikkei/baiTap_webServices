package com.data.session02.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "screen_rooms")
@Data
public class ScreenRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
}
