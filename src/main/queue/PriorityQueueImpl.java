package main.queue;

public class PriorityQueueImpl {
    int MAX = 20;
    int arr[] = new int[MAX];
    int noItems;

    public PriorityQueueImpl() {
        noItems =0;
    }

    public void insert(int val){
        int i;
        if(noItems ==0){
            arr[0] = val;
            noItems++;
            return;
        }

        for (i = noItems-1; i >=0 ; i--) {
            if(val > arr[i]){
                arr[i+1]= arr[i];
            }else {
                break;
            }
        }
        arr[i+1]= val;
        noItems++;
    }

    public void printQueue(){
        for (int i = 0; i <noItems ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int remove(){
        return arr[--noItems];
    }
    public boolean isEmpty(){
        return noItems==0;
    }
    public boolean isFull(){
        return noItems==MAX;
    }

    public static void main(String[] args) {
        PriorityQueueImpl priorityQueue = new PriorityQueueImpl();
        priorityQueue.insert(12);
        priorityQueue.insert(7);

        priorityQueue.insert(15);

        priorityQueue.insert(10);

        priorityQueue.insert(11);

        priorityQueue.insert(6);

        priorityQueue.printQueue();

        System.out.println("Removed Elements :" +priorityQueue.remove());

        priorityQueue.printQueue();


    }
}
