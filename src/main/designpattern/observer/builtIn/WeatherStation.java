package main.designpattern.observer.builtIn;

public  class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        WeatherData weatherData1 = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        CurrentConditionsDisplay currentConditionsDisplay1 = new CurrentConditionsDisplay(weatherData1);
        weatherData.setMeasurements(80, 65, 30.4F);
        weatherData.deleteObserver(currentConditionsDisplay1);
        weatherData1.setMeasurements(80, 65, 30.4F);
        //currentConditionsDisplay.display();

        //weatherData.removeConsumer(currentConditionsDisplay);
        //weatherData.setMeasurements(80,65,30.4F);    }
    }
}