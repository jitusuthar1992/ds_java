package design.observer.pattern.observer.java.builtIn;

import design.observer.pattern.impl.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement {
    Observable observable;
    private float temp;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions : "+ temp + "F Degrees and "+ humidity + " % humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            this.temp = ((WeatherData) o).getTemp();
            this.humidity = ((WeatherData) o).getHumidity();
            display();
        }
    }
}
