package main.greedy;


import java.util.Arrays;

public class FractionalKnapSack {

    class Node  {
        int val;
        int weight;
        double ratio;

        public Node(int val, int weight, double ratio) {
            this.val = val;
            this.weight = weight;
            this.ratio = ratio;
        }
    }

    int getMaxValue(int weight[], int values[] , int totalWeight){
        Node[] nodes = new Node[weight.length];
        for (int i = 0; i <weight.length ; i++) {
            double ratio = (values[i]/1.0) / (weight[i]/1.0);
            nodes[i] = new Node(values[i],weight[i],ratio);
        }

        Arrays.sort(nodes,(n1,n2)-> (int) (n2.ratio - n1.ratio));
        int ans = 0 , s=0;
        for(int i =0;i< nodes.length;i++){
            if(s+nodes[i].weight < totalWeight){
                ans += nodes[i].val;
                s+=nodes[i].weight;
            }else {
                double x= (totalWeight-s)*1.0;
                ans += ( x* nodes[i].ratio);
                break;
            }
        }
        return ans;
    }

}
