package entity.shop;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "shop_Product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int price;
    private int stock;

}
