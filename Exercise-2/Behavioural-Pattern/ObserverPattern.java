import java.util.ArrayList; // Import ArrayList
import java.util.List;      // Import List

// Observable (Subject)
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer Interface
interface Observer {
    void update(int temperature);
}

// Concrete Observers
class PhoneDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Phone Display: Temperature is now " + temperature + " degrees.");
    }
}

class WebDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Web Display: Temperature is now " + temperature + " degrees.");
    }
}

// Main Class
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        WebDisplay webDisplay = new WebDisplay();

        station.addObserver(phoneDisplay);
        station.addObserver(webDisplay);

        // Simulate temperature updates
        station.setTemperature(25);
        station.setTemperature(30);
    }
}
