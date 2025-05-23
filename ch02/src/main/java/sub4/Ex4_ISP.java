package sub4;

interface Workable {
    void work();
};
interface Eatable {
    void eat();
};
interface Sleepable {
    void sleep();
};

class HumanWorker implements Workable, Eatable, Sleepable {
    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Human is sleeping");
    }
}

class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}

public class Ex4_ISP {
    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        human.eat();
        human.work();
        human.sleep();

        RobotWorker robot = new RobotWorker();
        robot.work();
    }
}
