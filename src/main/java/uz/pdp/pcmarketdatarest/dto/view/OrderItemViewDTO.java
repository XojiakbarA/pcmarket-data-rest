package uz.pdp.pcmarketdatarest.dto.view;

import lombok.Data;

@Data
public class OrderItemViewDTO {
    private Long id;
    private ProductViewDTO product;
    private Integer count;
    private Double price;
}
