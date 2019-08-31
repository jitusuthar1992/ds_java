package main.array.hackerrank;
import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {
    static List<Integer> compareTriplets(int[] a, int[] b) {
        List<Integer> listCount = new ArrayList<>();
        if(a.length != b.length)
            return listCount;
        int acount =0,bcount=0;

        for(int i=0;i<a.length;i++){
            if(a[i]>b[i])
                acount++;
            if(b[i]>a[i])
                bcount++;
        }

        listCount.add(acount);
        listCount.add(bcount);

       //Collections.sort(listCount);
        return listCount;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 20, 20, 30 };
        int[] b = new int[] { 20, 20, 50 };
        System.out.println(compareTriplets(a, b));
    }

}
