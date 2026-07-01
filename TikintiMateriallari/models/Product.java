package com.example.TikintiMateriallari.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "price" ,precision = 10 , scale = 2)
    private BigDecimal price;
    private String description;
    private String shortDescription;
    private String specification;


    private int quantity;
    @Column(unique = true)
    private String slug;


    @ManyToOne
    private Category category;




    private double cashbackPercent;

    @OneToMany(mappedBy = "product")
    private List<Photo> photos = new ArrayList<>();

}
