package entity.shop;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shop_Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MYSQL의 auto_increment 처리 // orderid count가 자동으로 들어감
    private int orderId;
    private int orderPrice;
    private int orderStatus;
    private String orderer;

    @CreationTimestamp
    private LocalDateTime orderDate;

}
