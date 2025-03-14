package com.example.dio.model;

import com.example.dio.enums.DietType;
import com.example.dio.enums.StockStatus;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name ="food_item",indexes = {
        @Index(name ="idx_food",columnList = "name")
})
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private long itemId;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="description")
    private String description;

    @Column(name="stock")
    private int stock;

    @Column(name="availability")
    private StockStatus availability;

    @Column(name="dietType")
    private DietType dietType;

    @Column(name="created_at")
    @CreatedDate
    private LocalDate createdAt;

    @Column(name="last_modified_at")
    @LastModifiedDate
    private LocalDate lastModifiedAt;

    @ManyToOne
    private CusineType cusineType;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "foodItem")
    private List<CartItem> cartItems;
}
