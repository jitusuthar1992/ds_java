package main.java1;

/**
 * @author jitendra.kumar01
 * 12/12/19
 */
public  class CustomImmutableClass {
    private final String var ;

    public String getVar() {
        return var;
    }

    public CustomImmutableClass(String var) {
        this.var = var;
    }

    public static void main(String[] args) {
        CustomImmutableClass cs = new CustomImmutableClass("Test");
        System.out.println(cs.getVar());
        // Uncommenting below line causes error
        //cs.var ="Test1";
    }
}
