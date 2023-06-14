package main.dp;

public class MinEditDistance {
    public static int minDistance(char[] s1 , char[] s2){
        int m = s1.length;
        int n = s2.length;
        int dist[][] = new int[m+1][n+1];
        for (int i = 0; i <=m ; i++) {
            dist[i][0] = i;
        }
        for (int i = 0; i <=n ; i++) {
            dist[0][i] = i;
        }

        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(s1[i-1]==s2[j-1]){
                    dist[i][j] = dist[i-1][j-1];
                }else{
                    dist[i][j] = 1+ Math.min(dist[i-1][j-1],Math.min(dist[i-1][j],dist[i][j-1]));
                }
            }
        }
        return dist[m][n];
    }

    public static void main(String[] args) {
        System.out.println(MinEditDistance.minDistance("ABCAB".toCharArray(),"EACB".toCharArray()));
    }
}
