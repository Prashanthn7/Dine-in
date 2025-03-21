package com.example.dio.repository;

import com.example.dio.model.CartItem;
import com.example.dio.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    @Query("Select c from CartItem c WHERE c.table = :table AND c.isOrdered =false")
    List<CartItem> findByTable(@Param("table")Table table);

}
