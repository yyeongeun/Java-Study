package sub5;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

class NewsPublisher implements Subject {
    private List<Observer> observers;
    private String latestNews;

    public NewsPublisher() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        this.latestNews = message;
        for (Observer observer : this.observers) {
            observer.update(this.latestNews);
        }
    }

    public void publishNews(String news) {
        System.out.println("새로운 뉴스 발행: " + news);
        notifyObservers(news);
    }
}

class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + "님, 새로운 뉴스 도착: " + message);
    }
}

public class Ex3_Observer {

    public static void main(String[] args) {
        NewsPublisher publisher = new NewsPublisher();

        NewsPublisher subscriber1 = new NewsPublisher("Kim");
        NewsPublisher subscriber2 = new NewsPublisher("Lee");

        publisher.registerObserver(subscriber1);
        publisher.registerObserver(subscriber2);

    }

}
