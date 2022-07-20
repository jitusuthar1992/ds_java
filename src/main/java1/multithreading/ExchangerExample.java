package main.java1.multithreading;

import java.util.concurrent.Exchanger;

/**
 * @author jitendra.kumar01
 * 23/02/20
 */
public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        // Starting two threads
        new Thread(new Producer3(exchanger)).start();
        new Thread(new Consumer3(exchanger)).start();
    }

}

class Country {

    private String countryName;

    public Country(String countryName) {
        super();
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}

class Producer3 implements Runnable {
    Exchanger ex;

    public Producer3(Exchanger ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            Country country = null;
            if (i == 0)
                country = new Country("India");
            else
                country = new Country("Bhutan");

            try {
                // exchanging with an dummy Country object
                Country dummyCountry = (Country) ex.exchange(country);
                System.out.println("Got country object from Consumer thread : " + dummyCountry.getCountryName());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer3 implements Runnable {

    Exchanger ex;

    Consumer3(Exchanger ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                // Getting Country object from producer thread
                // giving dummy country object in return
                Country country = (Country) ex.exchange(new Country("Dummy"));
                System.out.println("Got country object from Producer thread : " + country.getCountryName());

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}