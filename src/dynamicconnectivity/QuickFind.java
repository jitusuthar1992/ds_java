package dynamicconnectivity;

public class QuickFind {
    private int[] id;

    public QuickFind(int id[]) {
        for (int i = 0; i <id.length ; i++) {
            id[i] =i;
        }
    }

    public  boolean isConnected(int p , int q){
        return (id[p]==id[q]);
    }

    public void union(int p , int q){
        int idp = id[p];
        int idq= id[q];

        for (int i = 0; i <id.length ; i++) {
            if(id[i]== idp){
                id[i] = idq;
            }
        }
    }

}
