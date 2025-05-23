package sub2.shop;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        // 쇼핑몰 생성
        Shopping shopping = new Shopping();

        // 고객 생성
        Customer customer1 = new Customer("A101", "김유신");
        Customer customer2 = new Customer("A102", "김춘추");

        // 고객 추가
        shopping.addCustomer(customer1);
        shopping.addCustomer(customer2);

        // 제품 생성
        Product tshirt = new Clothes("티셔츠", 15000);
        Product orange = new Food("오렌지", 3000);
        Product banana = new Food("바나나", 3500);

        // 주문 생성
        Order order1 = new Order(1, customer1);
        order1.addProduct(orange);
        order1.addProduct(tshirt);
        Order order2 = new Order(2, customer2);
        order2.addProduct(tshirt);
        order2.addProduct(banana);

        // 주문 추가
        shopping.addOrder(order1);
        shopping.addOrder(order2);

        // 모든 주문 출력
        List<Order> orders = shopping.getOrders();

/*
        for (Order order : orders) {
            System.out.println("주문번호 : " + order.getOrderNo());
//            System.out.println("고객이름 : " + order.getCustomer().getName());
            System.out.println("주문금액 : " + order.getTotalPrice());
            System.out.println("주문목록");

 */
        }

    }
}