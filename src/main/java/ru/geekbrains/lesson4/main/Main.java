package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.dao.ArticleDAO;
import ru.geekbrains.lesson4.data.ArticleData;
import ru.geekbrains.lesson4.entity.Article;
import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.entity.User;
import ru.geekbrains.lesson4.repositories.*;

import java.util.List;
import java.util.Optional;

//Здесь реализована пагинация;;
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        //ArticleDAO articleDAO = applicationContext.getBean("articleDAO", ArticleDAO.class);

        CategoryDataRepository categoryDataRepository = applicationContext.getBean("categoryDataRepository", CategoryDataRepository.class);
        CategoriesRepository categoriesRepository = applicationContext.getBean("categoriesRepository", CategoriesRepository.class);
        CategoriesPaginationRepository categoriesPaginationRepository = applicationContext.getBean("categoriesPaginationRepository", CategoriesPaginationRepository.class);

        categoriesRepository.save(new Category("Fruits", new Product("Orange",100l,80.0)));
        categoriesRepository.save(new Category("Berries", new Product("Cherry",100l,150.0)));
        categoriesRepository.save(new Category("Fruits", new Product("Apple", 200l,60.0)));
        categoriesRepository.save(new Category("Vegetables", new Product("Pumpkin", 500l,30.0)));
        categoriesRepository.save(new Category("Berries", new Product("Blackberry", 50l, 250.0)));

//        ArticleDataRepository articleDataRepository = applicationContext.getBean("articleDataRepository", ArticleDataRepository.class);

//        ArticlesPaginationRepository articlesPaginationRepository = applicationContext.getBean("articlesPaginationRepository", ArticlesPaginationRepository.class);
//
//        ArticlesRepository articlesRepository = applicationContext.getBean("articlesRepository", ArticlesRepository.class);
//        articlesRepository.save(new Article("New Title 1", new User("Alex")));
//        articlesRepository.save(new Article("New Title 2", new User("Alena")));
//        articlesRepository.save(new Article("New Title 3", new User("Milena")));
//        articlesRepository.save(new Article("New Title 4", new User("Lena")));
//        articlesRepository.save(new Article("New Title 5", new User("Artem")));
//        articlesRepository.save(new Article("New Title 6", new User("Polina")));
//        articlesRepository.save(new Article("New Title 7", new User("Vika")));
//        articlesRepository.save(new Article("New Title 8", new User("Veronika")));
//        articlesRepository.save(new Article("New Title 9", new User("Petr")));
//        articlesRepository.save(new Article("New Title 10", new User("Dima")));

//        List<Article> articles = articlesRepository.findByTitle("New Title");
//        System.out.println("articles = " + articles);
//
//        Article article2 = articlesRepository.findById(2l).get();
//        System.out.println("article2 = " + article2);

//        Optional<ArticleData> optional = articleDataRepository.findOneById(8L);
//        System.out.println("id = " + optional.get().getId() + ", " + optional.get().getTitle());

        Pageable pageable = PageRequest.of(1, 2);

        Page<Category> categoryPage = categoriesPaginationRepository.findAll(pageable);
        System.out.println(categoryPage.getContent());
    }

}
