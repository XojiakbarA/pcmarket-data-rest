package uz.pdp.pcmarketdatarest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uz.pdp.pcmarketdatarest.Mapper;
import uz.pdp.pcmarketdatarest.dto.request.OrderDTO;
import uz.pdp.pcmarketdatarest.dto.view.OrderViewDTO;
import uz.pdp.pcmarketdatarest.entity.Order;
import uz.pdp.pcmarketdatarest.entity.OrderItem;
import uz.pdp.pcmarketdatarest.entity.OrderStatus;
import uz.pdp.pcmarketdatarest.entity.Product;
import uz.pdp.pcmarketdatarest.exception.ProductNotEnoughException;
import uz.pdp.pcmarketdatarest.exception.ResourceNotFoundException;
import uz.pdp.pcmarketdatarest.repository.OrderRepository;
import uz.pdp.pcmarketdatarest.service.OrderService;
import uz.pdp.pcmarketdatarest.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private Mapper mapper;

    @Transactional
    @Override
    public OrderViewDTO create(OrderDTO dto) {
        Order order = new Order();
        order.setName(dto.getName());
        order.setAddress(dto.getAddress());
        order.setPhoneNumber(dto.getPhoneNumber());
        order.setEmail(dto.getEmail());

        dto.getOrderItems().forEach(i -> {
            Product product = productService.findById(i.getProductId());
            if (product.getCount() < i.getCount()) {
                throw new ProductNotEnoughException(product.getCount());
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setCount(i.getCount());
            orderItem.setPrice(product.getPrice());

            order.getOrderItems().add(orderItem);
            product.setCount(product.getCount() - i.getCount());
            productService.save(product);
        });

        return mapper.mapToDTO(save(order));
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderViewDTO update(OrderDTO dto, Long id) {
        Order order = findById(id);
        if (dto.getName() != null && !dto.getName().isBlank()) {
            order.setName(dto.getName());
        }
        if (dto.getAddress() != null && !dto.getAddress().isBlank()) {
            order.setAddress(dto.getAddress());
        }
        if (dto.getPhoneNumber() != null) {
            order.setPhoneNumber(dto.getPhoneNumber());
        }
        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            order.setEmail(dto.getEmail());
        }
        return mapper.mapToDTO(save(order));
    }

    @Override
    public List<OrderViewDTO> findAll() {
        return orderRepository.findAll().stream().map(o -> mapper.mapToDTO(o)).collect(Collectors.toList());
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(Order.class.getSimpleName(), id)
        );
    }

    @Override
    public void deleteById(Long id) {
        Order order = findById(id);
        if (order.getStatus() == OrderStatus.ACTIVE) {
            recoveryProductCounts(order);
        }
        orderRepository.deleteById(id);
    }

    @Override
    public void cancel(Long id) {
        Order order = findById(id);
        recoveryProductCounts(order);
        order.setStatus(OrderStatus.CANCEL);
        save(order);
    }

    @Override
    public void delivered(Long id) {
        Order order = findById(id);
        order.setStatus(OrderStatus.DELIVERED);
        save(order);
    }
    
    private void recoveryProductCounts(Order order) {
        order.getOrderItems().forEach(i -> {
            Product product = productService.findById(i.getProduct().getId());
            product.setCount(product.getCount() + i.getCount());
            productService.save(product);
        });
    }
}
