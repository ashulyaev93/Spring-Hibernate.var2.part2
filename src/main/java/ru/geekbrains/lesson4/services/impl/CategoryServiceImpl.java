package ru.geekbrains.lesson4.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.repositories.CategoriesRepository;

import java.util.List;

@Service
public class CategoryServiceImpl{
    private CategoriesRepository categoriesRepository;

    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }
    public void getProductFromCategoryByMinPrice(){
        List<Category> productFromCategoryByMinPrice = categoriesRepository.getProductFromCategoryByMinPrice();
        System.out.println(productFromCategoryByMinPrice);
    }
}
