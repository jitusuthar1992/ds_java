package main.designpattern.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    //private WeatherData weatherData;
    private float temp;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        //this.weatherData = weatherData;
        weatherData.registerObjerver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions : " + temp + "F Degrees and " + humidity + " % humidity");
    }

    public static interface Subject {
        void registerObjerver(Observer o);

        void removeConsumer(Observer o);

        void notifyConsumers();

    }
}
