package main.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class kClosestPointFromOrigin {
    static class Coordinates {
        int x, y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistanceFromOrigin() {
            return (x * x + y * y);
        }
    }

    public static List<Coordinates> kClosestPointFromOriginUsingList(List<Coordinates> listOfCoordinate, int k) {

        if (listOfCoordinate.size() == 0) {
            return new ArrayList<>();
        }

        Collections.sort(listOfCoordinate, (c1, c2) -> c1.getDistanceFromOrigin() - c2.getDistanceFromOrigin());
        List<Coordinates> result = new ArrayList<>();

        int i = 0;
        while (i < listOfCoordinate.size() && i < k) {
            result.add(listOfCoordinate.get(i));
            i++;
        }

        return result;
    }

    public static List<Coordinates> kClosestPointFromOriginUsingMinHeap(List<Coordinates> listOfCoordinate, int k) {

        if (listOfCoordinate.size() == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<Coordinates> minHeap = new PriorityQueue<>((c1, c2) -> c1.getDistanceFromOrigin() - c2.getDistanceFromOrigin());
        minHeap.addAll(listOfCoordinate);

        int i =0;
        List<Coordinates> result = new ArrayList<>();

        while (!minHeap.isEmpty() && i <k){
            result.add(minHeap.poll());
            i++;
        }
        return result;
    }

    public static List<Coordinates> kClosestPointFromOriginUsingMaxHeap(List<Coordinates> listOfCoordinate, int k) {

        if (listOfCoordinate.size() == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<Coordinates> maxHeap = new PriorityQueue<>((c1, c2) -> c2.getDistanceFromOrigin() - c1.getDistanceFromOrigin());

        for (int i = 0; i <k ; i++) {
            maxHeap.add(listOfCoordinate.get(i));
        }

        for (int i =k;i<listOfCoordinate.size();i++){
            if(listOfCoordinate.get(i).getDistanceFromOrigin() < maxHeap.peek().getDistanceFromOrigin()){
                maxHeap.poll();
                maxHeap.add(listOfCoordinate.get(i));
            }
        }
        List<Coordinates> result = new ArrayList<>();

        while(!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        Coordinates c1 = new Coordinates(2, 3);
        Coordinates c2 = new Coordinates(1, 4);
        Coordinates c3 = new Coordinates(3, 5);
        Coordinates c4 = new Coordinates(0, 4);

        List<Coordinates> listOfCoordinate = new ArrayList<>();
        listOfCoordinate.add(c1);
        listOfCoordinate.add(c2);
        listOfCoordinate.add(c3);
        listOfCoordinate.add(c4);

        List<Coordinates> kClosestPointsUsingList = kClosestPointFromOrigin.kClosestPointFromOriginUsingList(listOfCoordinate, 2);
        for(Coordinates c: kClosestPointsUsingList) {
            System.out.println(c.x + " " + c.y);
        }

        System.out.println();

        List<Coordinates> kClosestPointsUsingMinHeap = kClosestPointFromOrigin.kClosestPointFromOriginUsingMinHeap(listOfCoordinate, 2);
        for(Coordinates c: kClosestPointsUsingMinHeap) {
            System.out.println(c.x + " " + c.y);
        }

        System.out.println();

        List<Coordinates> kClosestPointsUsingMaxHeap = kClosestPointFromOrigin.kClosestPointFromOriginUsingMaxHeap(listOfCoordinate, 2);
        for(Coordinates c: kClosestPointsUsingMaxHeap) {
            System.out.println(c.x + " " + c.y);
        }
    }
}