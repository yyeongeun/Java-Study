package repository;

import entity.shop.Orderitem;
import jpa.JpaRepository;

public class OrderitemRepository extends JpaRepository<Orderitem, Integer> {
    public OrderitemRepository() {
        super(Orderitem.class);
    }
}
