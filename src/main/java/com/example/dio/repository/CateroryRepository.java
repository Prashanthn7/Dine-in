package com.example.dio.repository;

import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.Category;
import com.example.dio.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CateroryRepository extends JpaRepository<Category,String> {

//    @Query("SELECT DISTINCT f FROM FoodItem f INNER JOIN f.category c WHERE c.category = :category1 and c.category =:category2")
//    List<FoodItem> findFoodItemByCategory(@Param Category category1,@Param Category category2);

    @Query("""
        SELECT f FROM FoodItem f 
        WHERE :categoryCount = (
            SELECT COUNT(DISTINCT c.category) 
            FROM f.categories c 
            WHERE c.category IN :categories
        )
    """)
    List<FoodItem> findFoodItemsByAllCategories(@Param("categories") List<String> categories,
                                                @Param("categoryCount") long categoryCount);
}
