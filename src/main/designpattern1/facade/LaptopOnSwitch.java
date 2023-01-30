package main.designpattern1.facade;

public class LaptopOnSwitch {
    SoftwareCheck softwareCheck;
    HardWareChecks hardWareChecks;

    public LaptopOnSwitch() {
        softwareCheck = new SoftwareCheck();
        hardWareChecks = new HardWareChecks();
    }

    void swithOnLaptop(){
        if(hardWareChecks.checkAllHardware() && softwareCheck.checkSoftwareOnBoot()){
            System.out.println("Switching on Laptop");
        }
    }
}
