package com.data.session07.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_slips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentSlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Double money;

    private LocalDateTime createdAt;
}
