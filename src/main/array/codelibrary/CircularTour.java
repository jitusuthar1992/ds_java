package main.array.codelibrary;

import java.util.List;

public class CircularTour {
    class PetrolPump {
        int distance;
        int fuel;
    }

    int getStartPoint(List<PetrolPump> pumps){
        int requiredFuel =0 ;
        int extraFuel =0;
        int start  =0;

        for (int i = 0; i <pumps.size() ; i++) {
            extraFuel += (pumps.get(i).fuel -pumps.get(i).distance);
            if(extraFuel < 0){
                start = i+1 ;
                requiredFuel += extraFuel;
                extraFuel =0;
            }
        }
        if(requiredFuel+extraFuel >=0)
            return start;
        return -1;
    }
}
