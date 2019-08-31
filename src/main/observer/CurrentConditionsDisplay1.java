package main.observer;

public class CurrentConditionsDisplay1 implements Observer, DisplayElement {
    //private WeatherData weatherData;
    private float temp;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay1(WeatherData weatherData) {
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
        System.out.println("Current Conditions : "+ temp + "F Degrees and "+ humidity + " % humidity");
    }
}
