package main.lld.parkinglot.model;

public enum ParkingSlotType {
    TwoWheeler{
        public double getPriceForParking(long duration){
            return 0.05 * duration;
        }
    },

    Compact{
        public double getPriceForParking(long duration){
            return 0.075 * duration;
        }
    },
    Medium{
        public double getPriceForParking(long duration){
            return 0.09 * duration;
        }
    },

    Large{
        public double getPriceForParking(long duration){
            return 0.10 * duration;
        }
    };
    public abstract double getPriceForParking(long duration);

}
