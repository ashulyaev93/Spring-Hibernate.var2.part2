package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.dao.ArticleDAO;
import ru.geekbrains.lesson4.dao.CategoryDAO;
import ru.geekbrains.lesson4.entity.Article;
import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.entity.User;
import ru.geekbrains.lesson4.repositories.ArticlesRepository;
import ru.geekbrains.lesson4.repositories.CategoriesRepository;
import ru.geekbrains.lesson4.repositories.ProductRepository;
import ru.geekbrains.lesson4.services.impl.CategoryServiceImpl;
import ru.geekbrains.lesson4.services.impl.ProductServiceImpl;

//через этот класс вывожу категории с товарами; Почему это делается именно через DAO?
public class MainDAO {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CategoriesRepository categoriesRepository = applicationContext.getBean("categoriesRepository", CategoriesRepository.class);

        categoriesRepository.save(new Category("Fruits", new Product("Orange",100l,80.0)));
        categoriesRepository.save(new Category("Berries", new Product("Cherry",100l,150.0)));
        categoriesRepository.save(new Category("Fruits", new Product("Apple", 200l,60.0)));
        categoriesRepository.save(new Category("Vegetables", new Product("Pumpkin", 500l,30.0)));
        categoriesRepository.save(new Category("Berries", new Product("Blackberry", 50l, 250.0)));


        CategoryDAO categoryDAO = applicationContext.getBean("categoryDAO", CategoryDAO.class);

        categoryDAO.findAll().stream().forEach(System.out::println);

        //Вывод JPQL запроса;
        ProductRepository productsRepository = applicationContext.getBean("productRepository", ProductRepository.class);
        ProductServiceImpl productServiceImpl = new ProductServiceImpl(productsRepository);
        productServiceImpl.getProductByMaxPrice();
        productServiceImpl.getProductByMinPrice();
//        productServiceImpl.getProductByMinPriceAndMaxPrice();


//        ArticlesRepository articlesRepository = applicationContext.getBean("articlesRepository", ArticlesRepository.class);
//
//        articlesRepository.save(new Article("New Title 1", new User("Alex")));
//        articlesRepository.save(new Article("New Title 2", new User("Alena")));
//        articlesRepository.save(new Article("New Title 3", new User("Milena")));

//        ArticleDAO articleDAO = applicationContext.getBean("articleDAO", ArticleDAO.class);
//
//        articleDAO.findAll().stream().forEach(System.out::println);

    }
}
