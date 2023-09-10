package uz.pdp.pcmarketdatarest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Category> subCategories;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;
}
