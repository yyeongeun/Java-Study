package entity.shop;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "shop_Order_item")

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    private int orderId;
    private int productId;
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

}
