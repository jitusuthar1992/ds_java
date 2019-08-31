package main.custom;

import java.util.Arrays;

public class CustomArrayList {
    private Object[] myStore;
    private int size =0;

    public CustomArrayList() {
        myStore = new Object[10];
    }

    public Object get(int index){
        if(index <size){
            return myStore[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void add(Object obj){
        if(myStore.length - size <= 5){
            increaseSize();
        }
        myStore[size++] =obj;
    }

    public Object remove(int index){
        if(index < size){
            Object obj = myStore[index];
            myStore[index] = null;
            int tmp = index;
            while(tmp < size){
                myStore[tmp] =myStore[tmp+1];
                myStore[tmp+1] = null;
                tmp++;
            }
            size--;
            return obj;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    public void increaseSize(){
        myStore = Arrays.copyOf(myStore,myStore.length*2);
        System.out.println("\nNew length: "+myStore.length);

    }

    public int size(){
        return size;
    }

    public static void main(String a[]){
        CustomArrayList mal = new CustomArrayList();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
        mal.add(new Integer(29));
        System.out.println("Element at Index 5:"+mal.get(5));
        System.out.println("List size: "+mal.size());
        System.out.println("Removing element at index 2: "+mal.remove(2));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
    }
}
