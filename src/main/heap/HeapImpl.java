package main.heap;

public class HeapImpl {
    int size;
    int arr[] = new int[20];

    public void insermaxHeapNewValue(int val){
        arr[size] = val;
        int index = size;
        int parent = (index-1)/2;

        while (parent >=0 && arr[parent] < arr[index]){
            int t = arr[parent];
            arr[parent] = arr[index];
            arr[index] = t;

            t = parent;
            index = parent;
            parent = (t-1)/2;
        }
        size++;
    }

    public void inserMinHeapNewValue(int val){
        arr[size] = val;
        int index = size;
        int parent = (index-1)/2;

        while (parent >=0 && arr[parent] > arr[index]){
            int t = arr[parent];
            arr[parent] = arr[index];
            arr[index] = t;

            t = parent;
            index = parent;
            parent = (t-1)/2;
        }
        size++;
    }

    public int getMax(){
        return arr[0];
    }

    public int getMin(){
        return arr[0];
    }

    public int removeMaxFromMaxHeap(){
            int max = arr[0];
            arr[0] = arr[size-1];
            size = size-1;
            maxHepify(0);
            return max;
    }

    public int removeMinFromMinHeap(){
        int max = arr[0];
        arr[0] = arr[size-1];
        size = size-1;
        minHepify(0);
        return max;
    }

    private void minHepify(int i) {
        int l , r;

        l = 2*i +1;
        r = 2*i +2;

        int smallest = i;

        if(l < this.size && arr[l] < arr[smallest]){
            smallest = i ;
        }

        if(r < this.size && arr[r] < arr[smallest]){
            smallest = r ;
        }

        if(i != smallest){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            minHepify(smallest);
        }
    }

    public void maxHepify(int i) {
        int l , r;

        l = 2*i +1;
        r = 2*i +2;

        int largest = i;

        if(l < this.size && arr[l] > arr[largest]){
            largest = i ;
        }

        if(r < this.size && arr[r] > arr[largest]){
            largest = r ;
        }

        if(i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHepify(largest);
        }

    }

    public void buildMaxHeap(int arr[]){
        this.arr = arr;
        this.size = arr.length;

        for (int i = size/2-1; i >=0 ; i--) {
            maxHepify(i);
        }
    }

    public void buildMinHeap(int arr[]){
        this.arr = arr;
        this.size = arr.length;

        for (int i = size/2-1; i >=0 ; i--) {
            minHepify(i);
        }
    }

    public void heapSort(int arr[]){
        this.arr = arr;
        this.size = arr.length;
        for (int i = size/2-1; i >=0 ; i--) {
            maxHepify(i);
        }

        for (int i = size-1; i >=0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHepify(0);
        }
    }
}
