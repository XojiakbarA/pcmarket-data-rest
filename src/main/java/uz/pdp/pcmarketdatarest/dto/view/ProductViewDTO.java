package uz.pdp.pcmarketdatarest.dto.view;

import lombok.Data;

@Data
public class ProductViewDTO {
    private Long id;
    private String name;
    private Integer count;
    private Double price;
    private BrandViewDTO brand;
    private CategoryViewDTO category;
}
