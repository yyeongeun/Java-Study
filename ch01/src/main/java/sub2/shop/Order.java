package sub2.shop;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderNo;
    private Customer customer;
    private List<Product> products;
    private int totalPrice;

    public Order(int orderNo, Customer customer) {
        this.orderNo = orderNo;
        this.customer = customer;
        products = new ArrayList<>();
        totalPrice = 0;
    }
    public void addProduct(Product product){
        totalPrice += product.getPrice();
        products.add(product);
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getCustomer() {
        return customer;
    }

    public int getProducts() {
        return products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}
