package com.example.dio.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long billId;

    @Column(name ="generated_at")
    @CreatedDate
    private LocalDateTime generatedAt;

    @Column(name ="total_payable_amount")
    private double totalPayableAmount;

    @OneToMany
    private List<Order> orders;
}
