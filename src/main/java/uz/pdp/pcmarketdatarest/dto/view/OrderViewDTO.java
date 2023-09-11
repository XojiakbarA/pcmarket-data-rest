package uz.pdp.pcmarketdatarest.dto.view;

import lombok.Data;
import uz.pdp.pcmarketdatarest.entity.OrderStatus;

import java.util.Date;
import java.util.Set;

@Data
public class OrderViewDTO {
    private Long id;
    private Date date;
    private String name;
    private String address;
    private Long phoneNumber;
    private String email;
    private OrderStatus status;
    private Set<OrderItemViewDTO> orderItems;
}
