package sub5;


import javax.lang.model.util.SimpleElementVisitor6;

interface Coffee {
    String getDescription();
    int getCost();
}

class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public int getCost() {
        return 1500;
    }
}

interface CoffeeDecorator extends Coffee {
    String getSize();
}

class MilkDecorator implements CoffeeDecorator {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 500;
    }

    @Override
    public String getSize() {
        return "Tall";
    }
}

class SugarDecorator implements CoffeeDecorator {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 100;
    }

    @Override
    public String getSize() {
        return "Large";
    }
}

public class Ex2_Decorator {
    public static void main(String[] args) {

        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + "," + simpleCoffee.getCost());

        CoffeeDecorator milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + "," + milkCoffee.getCost());

        CoffeeDecorator sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.getDescription() + "," + sugarMilkCoffee.getCost() + "," + sugarMilkCoffee.getSize());

    }
}