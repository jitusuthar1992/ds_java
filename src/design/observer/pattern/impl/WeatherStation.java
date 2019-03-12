package design.observer.pattern.impl;

public  class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        CurrentConditionsDisplay1 currentConditionsDisplay1 = new CurrentConditionsDisplay1(weatherData);
        weatherData.setMeasurements(80,65,30.4F);
        weatherData.removeConsumer(currentConditionsDisplay);
        weatherData.setMeasurements(80,65,30.4F);    }
}
