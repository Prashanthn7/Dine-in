package com.example.dio.model;

import com.example.dio.enums.TableStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@jakarta.persistence.Table(name ="tables")
public class Table {

    @Column(name ="table_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tableId;

    @Column(name ="table_number")
    private int tableNumber;

    @Column(name ="table_capacity")
    private int tableCapacity;

    @Column(name="table_status")
    private TableStatus status;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<Staff> staffs;

    @OneToMany(mappedBy = "table")
    private List<CartItem> cartItems;

    @OneToMany
    private List<Order> orders;
}
