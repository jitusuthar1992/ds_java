package main.designpattern1.chainofresponsibility;

public abstract class Manager {
    protected Manager manager;
    protected int approvalLimit;
    protected String managerName ;

    public void setManager(Manager manager){
        this.manager = manager;
    }
    public void approveSalary(int empSalary){
        if(this.approvalLimit > empSalary){
            processSalary(empSalary);
        }else if(manager != null){
            manager.approveSalary(empSalary);
        }else {
            System.out.println("Cannot make offer to the candidate");
        }
    }

    public abstract void processSalary(int empSalary) ;
}
