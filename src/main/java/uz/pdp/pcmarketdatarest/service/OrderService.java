package uz.pdp.pcmarketdatarest.service;

import uz.pdp.pcmarketdatarest.dto.OrderDTO;
import uz.pdp.pcmarketdatarest.entity.Order;

public interface OrderService {
    Order findById(Long id);
    Order create(OrderDTO dto);
    Order update(OrderDTO dto, Long id);
    Order save(Order order);
    void deleteById(Long id);
    void cancel(Long id);
    void delivered(Long id);
}
