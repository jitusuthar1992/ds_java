package main.recusrsion.array;

public class InversionCount {

    int mergeAndCount(int arr[],int s, int e){
        int count =0;
        int mid = (s+e)/2;
        int len1 = mid-s +1;
        int len2 = e-mid;
        int left[] = new int[len1];
        int right[] = new int[len2];


        int k =s;
        for (int i = 0; i <len1 ; i++) {
            left[i]= arr[k++];
        }

        for (int i = 0; i <len2 ; i++) {
            right[i]= arr[k++];
        }

        int i =0 , j=0 ;
        k = s;
        while (i < len1 && j < len2){
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }else {
                count += (len1-i);
                arr[k++] = right[j++];
            }
        }
        while (i < len1 ){
            arr[k++] = left[i++];
        }
        while (j < len2 ){
            arr[k++] = right[j++];
        }
        return count;

    }

    int mergeSortAndCount(int arr[],int s, int e){

        if(s >= e)
            return 0;
        int mid = (s+e)/2;
        int count =0;
        count += mergeSortAndCount(arr,s,mid);
        count+= mergeSortAndCount(arr,mid+1,e);
        count+= mergeAndCount(arr,s,e);
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 20, 6, 4, 5 };
        System.out.println( new InversionCount().mergeSortAndCount(arr,0, arr.length-1));

    }
}
