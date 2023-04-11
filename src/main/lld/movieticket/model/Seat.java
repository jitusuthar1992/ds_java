package main.lld.movieticket.model;

public class Seat {
    private final String id;
    private final Integer rowNo;
    private final Integer seatNo;

    public Seat(final String id, final Integer rowNo, final Integer seatNo) {
        this.id = id;
        this.rowNo = rowNo;
        this.seatNo = seatNo;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public String getId() {
        return id;
    }
}
