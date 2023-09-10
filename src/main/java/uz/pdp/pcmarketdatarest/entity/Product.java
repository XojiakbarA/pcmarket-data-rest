package uz.pdp.pcmarketdatarest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    @ManyToMany
    private Set<Tag> tags;

    @ManyToMany
    private Set<AttributeName> attributeNames; //product details

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> attachments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;
}
