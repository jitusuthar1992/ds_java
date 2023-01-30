package main.designpattern1.chainofresponsibility;

import main.designpattern1.chainofresponsibility.impl.Director;
import main.designpattern1.chainofresponsibility.impl.HiringManager;
import main.designpattern1.chainofresponsibility.impl.SeniorManager;

public class ChainCreator {
    public Manager createChain(){
        Manager hiringManager = new HiringManager(1000000,"Sahil");
        Manager seniorManager = new SeniorManager(2000000,"Ankit");
        Manager director = new Director(3500000,"Bill");
        hiringManager.setManager(seniorManager);
        seniorManager.setManager(director);
        return hiringManager;
    }
}
