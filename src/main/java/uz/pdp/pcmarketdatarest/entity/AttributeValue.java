package uz.pdp.pcmarketdatarest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "attribute_values")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String value;

    @ManyToOne
    private AttributeName attributeName;
}
