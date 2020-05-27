package main.designpattern.chainofresponsibility;

public class Dimension {
    private int[] coordinates ;

    public Dimension() {
    }

    public Dimension(int x ) {
        this.coordinates = new int[]{x};
    }

    public Dimension(int x , int y ) {
        this.coordinates = new int[]{x,y};
    }

    public Dimension(int x , int y , int z ) {
        this.coordinates = new int[]{x,y,z};
    }

    public int[] getCoordinates() {
        return coordinates;
    }
}
