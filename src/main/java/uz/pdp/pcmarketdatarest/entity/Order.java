package uz.pdp.pcmarketdatarest.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date = new Date();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 12)
    private Long phoneNumber;

    @Column(nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    @Column(nullable = false)
    private OrderStatus status = OrderStatus.ACTIVE;
}
