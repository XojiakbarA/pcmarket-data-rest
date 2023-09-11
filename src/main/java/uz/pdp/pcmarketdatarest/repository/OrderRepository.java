package uz.pdp.pcmarketdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uz.pdp.pcmarketdatarest.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
