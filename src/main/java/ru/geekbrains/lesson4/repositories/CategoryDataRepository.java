package ru.geekbrains.lesson4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.data.CategoryData;
import ru.geekbrains.lesson4.entity.Category;

import java.util.Optional;

@Repository
public interface CategoryDataRepository extends JpaRepository<Category, Long> {

    Optional<CategoryData> findOneById(Long id);

}
