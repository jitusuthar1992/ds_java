package main.designpattern1.chainofresponsibility.impl;

import main.designpattern1.chainofresponsibility.Manager;

public class HiringManager extends Manager {
    public HiringManager(int approvalLimit , String managerName) {
        this.approvalLimit = approvalLimit;
        this.managerName = managerName;
    }

    @Override
    public void processSalary(int empSalary) {
        System.out.println(this.managerName + " has approved the salary at Level 1");
    }
}
