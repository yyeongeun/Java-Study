package sub3;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.OrderitemRepository;
import repository.ProductRepository;

public class ShopEntityTest {

    CustomerRepository customerRepository = new CustomerRepository();
    OrderRepository orderRepository = new OrderRepository();
    OrderitemRepository orderitemRepository = new OrderitemRepository();
    ProductRepository productRepository = new ProductRepository();

    @Test
    public void test1(){
        Order order = orderRepository.findByID(3);
        System.out.println(order);
    }


}
