package uz.pdp.pcmarketdatarest;

import org.springframework.stereotype.Component;
import uz.pdp.pcmarketdatarest.dto.view.*;
import uz.pdp.pcmarketdatarest.entity.*;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public OrderViewDTO mapToDTO(Order order) {
        OrderViewDTO dto = new OrderViewDTO();
        dto.setId(order.getId());
        dto.setDate(order.getDate());
        dto.setName(order.getName());
        dto.setAddress(order.getAddress());
        dto.setPhoneNumber(order.getPhoneNumber());
        dto.setEmail(order.getEmail());
        dto.setStatus(order.getStatus());
        Set<OrderItemViewDTO> orderItems = order.getOrderItems().stream().map(this::mapToDTO).collect(Collectors.toSet());
        dto.setOrderItems(orderItems);
        return dto;
    }
    public OrderItemViewDTO mapToDTO(OrderItem orderItem) {
        OrderItemViewDTO dto = new OrderItemViewDTO();
        dto.setId(orderItem.getId());
        dto.setProduct(mapToDTO(orderItem.getProduct()));
        dto.setCount(orderItem.getCount());
        dto.setPrice(orderItem.getPrice());
        return dto;
    }
    public BrandViewDTO mapToDTO(Brand brand) {
        if (brand == null) return null;
        BrandViewDTO dto = new BrandViewDTO();
        dto.setId(brand.getId());
        dto.setName(brand.getName());
        return dto;
    }
    public CategoryViewDTO mapToDTO(Category category) {
        if (category == null) return null;
        CategoryViewDTO dto = new CategoryViewDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
    public ProductViewDTO mapToDTO(Product product) {
        ProductViewDTO dto = new ProductViewDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCount(product.getCount());
        dto.setPrice(product.getPrice());
        dto.setBrand(mapToDTO(product.getBrand()));
        dto.setCategory(mapToDTO(product.getCategory()));
        return dto;
    }
}
