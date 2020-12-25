package ru.geekbrains.lesson4.dao;

import ru.geekbrains.lesson4.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    void save(Category category);
    Category findById(Long id);
    void update(Category category);
    void delete(Category category);
}
