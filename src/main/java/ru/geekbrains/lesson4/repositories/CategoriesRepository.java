package ru.geekbrains.lesson4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

//здесь запрос и когда его прописал вываливается исключение, что categoriesRepository не создан бин;
@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameCategory(String nameCategory);

    @Query("select a from Category a where a.product = :product")
    List<Category> findCategoryByProduct(@Param("product") Product product);

    @Query("SELECT p FROM Category p WHERE p.price = (SELECT min(price) FROM Category)")
    List<Category> getProductFromCategoryByMinPrice();
}
