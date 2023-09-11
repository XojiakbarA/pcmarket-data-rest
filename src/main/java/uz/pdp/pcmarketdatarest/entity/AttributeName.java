package uz.pdp.pcmarketdatarest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "attribute_names")
public class AttributeName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "attributeName", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AttributeValue> attributeValues;
}
