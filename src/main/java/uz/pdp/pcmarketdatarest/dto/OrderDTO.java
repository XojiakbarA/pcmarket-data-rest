package uz.pdp.pcmarketdatarest.dto;

import java.util.Set;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import uz.pdp.pcmarketdatarest.marker.OnCreate;

@Data
public class OrderDTO {
    @NotNull(message = "name is required", groups = OnCreate.class)
    @NotEmpty(message = "name must not be empty")
    private String name;

    @NotNull(message = "address is required", groups = OnCreate.class)
    @NotEmpty(message = "address must not be empty")
    private String address;

    @NotNull(message = "phoneNumber is required", groups = OnCreate.class)
    @Min(value = 100_000_000_000L, message = "phoneNumber must be 12 digits")
    @Max(value = 999_999_999_999L, message = "phoneNumber must be 12 digits")
    private Long phoneNumber;

    @NotNull(message = "email is required", groups = OnCreate.class)
    @NotEmpty(message = "email must not be empty")
    private String email;

    @Valid
    @NotNull(message = "orderItems must not be empty", groups = OnCreate.class)
    private Set<OrderItemDTO> orderItems;
}
