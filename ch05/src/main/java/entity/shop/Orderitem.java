package entity.shop;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "shop_Order_item")

public class Orderitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    private int orderId;
    private int productId;
    private int count;

}
