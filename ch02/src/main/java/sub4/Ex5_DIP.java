package sub4;

interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("전구 불이 켜졌습니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("전구 불이 꺼졌습니다.");
    }
}

class Switch {
    private Switchable switchable; // 구체적인 LightBulb 클래스에 직접 의존

    public Switch(Switchable switchable) {
        this.switchable = switchable;
    }

    public void operate() {
        // 스위치를 조작하는 로직 (예: 현재 상태에 따라 turnOn 또는 turnOff 호출)
        switchable.turnOn();
    }
}

public class Ex5_DIP {
    public static void main(String[] args) {
        LightBulb lightBulb = new LightBulb();
        Switch switchButton = new Switch(lightBulb);
        switchButton.operate();
    }
}