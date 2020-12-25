package ru.geekbrains.lesson4.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameCategory")
    private String nameCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "listProduct_id")
    private Product product;

    public Category() {
    }

    public Category(String nameCategory, Product product) {
        this.nameCategory = nameCategory;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                ", product={id='" + product.getId() + '\'' +
                ", nameProduct='" + product.getName() + '\'' +
                ", quantity='" + product.getQuantity() + '\'' +
                ", price='" + product.getPrice() + '\'' +
                "}}";
    }
}
