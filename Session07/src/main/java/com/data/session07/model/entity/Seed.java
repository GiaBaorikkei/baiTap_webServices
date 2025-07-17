package com.data.session07.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seeds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seedName;

    private Integer quantity;
}
