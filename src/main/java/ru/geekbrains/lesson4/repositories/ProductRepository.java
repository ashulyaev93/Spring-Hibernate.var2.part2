package ru.geekbrains.lesson4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThanEqual(Double price);
    List<Product> findAllByPriceGreaterThanOrderByPriceDesc(Double price);
    Product findByName(String name);

    //!!!!!!!!!!!!!!!!!!
    @Query("SELECT p FROM products p WHERE p.price = (SELECT max(price) FROM products)")
    List<Product> getProductByMaxPrice();
}
