package uz.pdp.pcmarketdatarest.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import uz.pdp.pcmarketdatarest.marker.OnCreate;

@Data
public class OrderItemDTO {
    @NotNull(message = "productId must not be empty", groups = OnCreate.class)
    @Positive(message = "productId must be a positive")
    private Long productId;

    @NotNull(message = "count must not be empty", groups = OnCreate.class)
    @Positive(message = "count must be a positive")
    private Integer count;
}
