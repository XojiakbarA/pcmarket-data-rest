package uz.pdp.pcmarketdatarest.service;

import uz.pdp.pcmarketdatarest.dto.request.OrderDTO;
import uz.pdp.pcmarketdatarest.dto.view.OrderViewDTO;
import uz.pdp.pcmarketdatarest.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderViewDTO> findAll();
    Order findById(Long id);
    OrderViewDTO create(OrderDTO dto);
    OrderViewDTO update(OrderDTO dto, Long id);
    Order save(Order order);
    void deleteById(Long id);
    void cancel(Long id);
    void delivered(Long id);
}
