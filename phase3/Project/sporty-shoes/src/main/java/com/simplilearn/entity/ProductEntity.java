package com.simplilearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    private String productName;
    private String size;
    private float price;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id")
    private CategoryEntity type;

}
