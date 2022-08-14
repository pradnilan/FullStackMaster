package com.simplilearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    /*@ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id_2")
    private ProductEntity product;*/

    public CategoryEntity(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }
}
