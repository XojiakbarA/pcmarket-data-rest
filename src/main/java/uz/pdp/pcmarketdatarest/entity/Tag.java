package uz.pdp.pcmarketdatarest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Product> products;
}
