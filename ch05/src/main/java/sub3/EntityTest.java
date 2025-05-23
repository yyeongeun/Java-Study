package sub3;


import entity.shop.Customer;
import repository.CustomerRepository;
import repository.OrderRepository;
import repository.OrderitemRepository;
import repository.ProductRepository;

public class EntityTest {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();
        OrderitemRepository orderitemRepository = new OrderitemRepository();
        ProductRepository productRepository = new ProductRepository();

        customerRepository.findALL().forEach(System.out::println);
        orderRepository.findALL().forEach(System.out::println);
        orderitemRepository.findALL().forEach(System.out::println);
        productRepository.findALL().forEach(System.out::println);

    }
}
