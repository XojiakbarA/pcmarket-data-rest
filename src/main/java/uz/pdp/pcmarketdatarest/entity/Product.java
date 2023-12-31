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
    private Integer count;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    @ManyToMany
    private Set<Tag> tags;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Attribute> attributes; //product details

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attachment> attachments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;
}
