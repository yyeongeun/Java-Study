package repository;

import entity.shop.Customer;
import jpa.JpaRepository;

public class CustomerRepository extends JpaRepository<Customer, Integer> {
    public CustomerRepository() {
        super(Customer.class);
    }
}
