package main.systemdesign.parkingslot.model;

import java.util.Date;

public class Ticket {

    private long id;
    private ParkingSlot parkingSlot;
    private Date entryTime;
    private Date exitTime;
    private String registractionNO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public String getRegistractionNO() {
        return registractionNO;
    }

    public void setRegistractionNO(String registractionNO) {
        this.registractionNO = registractionNO;
    }
}
