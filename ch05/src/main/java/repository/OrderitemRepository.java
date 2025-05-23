package repository;

import entity.shop.OrderItem;
import jpa.JpaRepository;

public class OrderitemRepository extends JpaRepository<OrderItem, Integer> {
    public OrderitemRepository() {
        super(OrderItem.class);
    }
}
