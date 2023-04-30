package main.recusrsion.array;

import java.util.ArrayList;

public class Subset {

   public static void solve(int arr[], ArrayList<ArrayList<Integer>> ans ,ArrayList<Integer> op, int index){
        if(index >= arr.length){
            ans.add(op);
            return;
        }

        solve(arr,ans,op,index+1);
        ArrayList<Integer> newOp = new ArrayList<>(op);
        int element = arr[index];
        newOp.add(element);
        solve(arr,ans,newOp,index+1);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> op = new ArrayList<>();
        int arr[] = {1,2,3};
        Subset.solve(arr,ans,op,0);
        System.out.println(ans);
    }
}
