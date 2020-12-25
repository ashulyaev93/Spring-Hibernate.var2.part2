package ru.geekbrains.lesson4.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Category;

@Repository
public interface CategoriesPaginationRepository extends PagingAndSortingRepository<Category, Long> {

}
