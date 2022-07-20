package main.java1.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class SerWithInheritance {
    public static void main(String[] args) {
        String fileName = "subclass.ser";

        Child subClass = new Child();
        subClass.setVar1(10);
        subClass.setVar2("Data");
        subClass.setVar3("Pankaj");

        try {
            SerializationUtil.serialize(subClass, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            Child subNew = (Child) SerializationUtil.deserialize(fileName);
            System.out.println("SubClass read = " + subNew);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}


class Super {
    int var1;
    String var2;

    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    //adding helper method for serialization to save/initialize super class state

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Super aSuper = (Super) o;
        return var1 == aSuper.var1 &&
                Objects.equals(var2, aSuper.var2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(var1, var2);
    }

    @Override
    public String toString() {
        return "Super{" +
                "var1=" + var1 +
                ", var2='" + var2 + '\'' +
                '}';
    }
}


class Child extends Super implements Serializable {

    private static final long serialVersionUID = -1322322139926390329L;

    //transient String var3;
    transient String var3;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();

        //notice the order of read and write should be same
        setVar1(ois.readInt());
        setVar2((String) ois.readObject());
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();

        oos.writeInt(getVar1());
        oos.writeObject(getVar2());
    }

    @Override
    public String toString() {
        return "Child{" +
                "var1=" + var1 +
                ", var2='" + var2 + '\'' +
                ", var3='" + var3 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Child child = (Child) o;
        return var3.equals(child.var3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), var3);
    }
}
