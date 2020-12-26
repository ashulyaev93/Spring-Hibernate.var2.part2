package ru.geekbrains.lesson4.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson4.entity.Article;
import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.repositories.CategoriesRepository;

import java.util.List;

@Service
public class CategoryServiceImpl{

    private CategoriesRepository categoriesRepository;

    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }
}
