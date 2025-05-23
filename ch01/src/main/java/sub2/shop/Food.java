package sub2.shop;

public class Food extends Product {

    private String name;
    private int price;

    public Food(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public int getPrice(){
        return price;
    }

    @Override
    public int getName(){
        return name;
    }

}
