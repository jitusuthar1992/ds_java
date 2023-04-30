package main.disjointset;

public class UnionFindProblem {

    int parent[] ;
    int rank[];

    public void initialize(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i <size ; i++) {
            parent[i] = i;
        }
    }
    public int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    public int find1(int x){
       if(parent[x] != x){
           parent[x] = find(parent[x]);
       }
       return parent[x];
    }

    public void union(int a , int b){
        int x = find(a);
        int y = find(b);
        if( x==y) return;

        if(rank[x] > rank[y]){
            parent[y] = x;
        }else if(rank[x] < rank[y]){
            parent[x] = y;
        }else {
            parent[y] = x;
            rank[x] = rank[x] +1;
        }
    }

    public void union1(int a , int b){
        int x = find(a);
        int y = find(b);
        if( x==y) return;
        parent[y] = x;
    }


    public boolean isDisjointSetElm(int a , int b){
        if(parent[a] == parent[b])
            return true;
        return false;
    }
    public static void main(String[] args) {
        UnionFindProblem obj = new UnionFindProblem();
        obj.initialize(10);
        obj.union(0,1);
        obj.union(2,7);
        obj.union(3,6);
        System.out.println(" (0,2) "+obj.isDisjointSetElm(0,2));
        obj.union(0,7);
        System.out.println(" (0,2) "+obj.isDisjointSetElm(0,2));
    }
}
