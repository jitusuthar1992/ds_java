package main.designpattern1.facade;

public class SoftwareCheck {
    OSCheckOnBoot osCheckOnBoot;
    DriverCheck driverCheck;

    public SoftwareCheck() {
        osCheckOnBoot = new OSCheckOnBoot();
        driverCheck = new DriverCheck();
    }
    boolean checkSoftwareOnBoot(){
        return osCheckOnBoot.checkRamOnBoot() && driverCheck.checkRamOnBoot();
    }
}
