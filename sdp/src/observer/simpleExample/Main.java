package observer.simpleExample;

import java.util.ArrayList;
import java.util.List;

/* ========================= */
/*        Observer           */
/* ========================= */
interface Observer {
    void update(String news); // Method to notify the observer
}

/* ========================= */
/*          Subject          */
/* ========================= */
interface Subject {
    void registerObserver(Observer observer);  // Add an observer
    void removeObserver(Observer observer);    // Remove an observer
    void notifyObservers();                    // Notify all observers
}

/* ========================= */
/*     Concrete Subject      */
/* ========================= */
class NewsAgency implements Subject {
    private String latestNews;
    private List<Observer> observers = new ArrayList<>();

    // Add an observer
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove an observer
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers of the latest news
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestNews);
        }
    }

    // Publish news and notify observers
    public void publishNews(String news) {
        this.latestNews = news;
        notifyObservers();
    }
}

/* ========================= */
/*    Concrete Observer      */
/* ========================= */
class NewsSubscriber implements Observer {
    private String name;

    NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news update: " + news);
    }
}

/* ========================= */
/*            Main           */
/* ========================= */
public class Main {
    public static void main(String[] args) {
        // Create the subject (news agency)
        NewsAgency agency = new NewsAgency();

        // Create observers (subscribers)
        NewsSubscriber subscriber1 = new NewsSubscriber("Alice");
        NewsSubscriber subscriber2 = new NewsSubscriber("Bob");

        // Register subscribers
        agency.registerObserver(subscriber1);
        agency.registerObserver(subscriber2);

        // Publish news
        agency.publishNews("Breaking News: Weather is sunny today!");

        // Unregister one subscriber and publish more news
        agency.removeObserver(subscriber1);
        agency.publishNews("Update: It might rain later today.");
    }
}
