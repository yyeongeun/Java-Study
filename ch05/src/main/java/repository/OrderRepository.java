package repository;

import entity.shop.Order;
import jpa.JpaRepository;

public class OrderRepository extends JpaRepository<Order, Integer> {
    public OrderRepository(){
        super(Order.class);
    }
}
