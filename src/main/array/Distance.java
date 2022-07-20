package main.array;

import java.util.*;

/* Write your class implementations here. Do not use access modifiers when declaring your classes. */

class Point2D {
    protected int x;
    protected int y;

    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double dist2D(Point2D p) {
        return Math.ceil(Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y)));
    }

    void printDistance(double d) {
        System.out.println(d);
    }
}

class Point3D extends Point2D {
    private int z;

    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    double dist3D(Point3D p) {
        return Math.sqrt(((this.x - p.x) * (this.x - p.x)) + ((this.y - p.y) * (this.y - p.y))
                + ((this.z - p.z) * (this.z - p.z)));
    }

    void printDistance(double d) {
        System.out.println(d);
    }
}

public class Distance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int z1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int z2 = scanner.nextInt();
        scanner.close();

        Point3D p1 = new Point3D(x1, y1, z1);
        Point3D p2 = new Point3D(x2, y2, z2);
        double d2 = p1.dist2D(p2);
        double d3 = p1.dist3D(p2);
        // The code below uses runtime polymorphism to call the overridden printDistance method:
        Point2D p = new Point2D(0, 0);
        p.printDistance(d2);
        p = p1;
        p.printDistance(d3);
    }
}