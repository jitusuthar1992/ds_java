package main.java1.multithreading.concurrent.utils;

/**
 * @author jitendra.kumar01
 * 23/02/20
 */
public class State {
    String name;
    long population;

    public State(String name, long population) {
        super();
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        State other = (State) obj;
        if (name.equalsIgnoreCase((other.name)))
            return true;
        return false;
    }
}
