package main.observer;


import java.util.ArrayList;

public class WeatherData implements CurrentConditionsDisplay.Subject {

    private ArrayList observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData( ) {
        this.observers =  new ArrayList();
    }

    @Override
    public void registerObjerver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeConsumer(Observer o) {
        int i = observers.indexOf(o);
        if (i  > -1)
            observers.remove(o);
    }

    @Override
    public void notifyConsumers() {
        for (int i = 0; i <observers.size() ; i++) {
            Observer o = (Observer) observers.get(i);
            o.update(temp,humidity,pressure);
        }
    }

    void measurementsChanged(){
        notifyConsumers();
    }

    public void setMeasurements(float temp, float humidity , float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
