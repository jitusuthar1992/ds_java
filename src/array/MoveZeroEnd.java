package array;

public class MoveZeroEnd {

    public static Integer[] zerosToEndSOl1(Integer[] arr){

        int count=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] !=0)
                arr[count++] =arr[i];
        }
        while(count <arr.length)
            arr[count++]=0;
        return arr;
    }

    public static Integer[] zerosToEndSOl2(Integer[] arr) {

        // Count of non-zero elements
        int count = 0;
        int temp;

        // Traverse the array. If arr[i] is
        // non-zero, then swap the element at
        // index 'count' with the element at
        // index 'i'
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] != 0)) {
                temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count++;
            }
        }
        return arr;


    }

}
