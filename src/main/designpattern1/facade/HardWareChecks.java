package main.designpattern1.facade;

public class HardWareChecks {
    MotherBoard motherBoard;
    Ram ram;

    public HardWareChecks() {
        this.motherBoard = new MotherBoard();
        this.ram = new Ram();
    }
    boolean checkAllHardware(){
        return motherBoard.checkMotherBoardOnBoot() &&  ram.checkRamOnBoot();
    }
}
