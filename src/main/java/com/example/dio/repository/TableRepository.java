package com.example.dio.repository;

import com.example.dio.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table,Long> {
}
