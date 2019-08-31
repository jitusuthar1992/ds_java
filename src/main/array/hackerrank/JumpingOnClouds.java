package main.array.hackerrank;

/*
Emma is playing a new mobile game that starts with consecutively numbered clouds.
Some of the clouds are thunderheads and others are cumulus. She can jump on any
cumulus cloud having a number that is equal to the number of the current cloud plus
or . She must avoid the thunderheads. Determine the minimum number of jumps it will
take Emma to jump from her starting postion to the last cloud. It is always possible
to win the game.

For each game, Emma will get an array of clouds numbered  if they are safe or  if they
must be avoided. For example,  indexed from . The number on each cloud is its index in
the list so she must avoid the clouds at indexes  and . She could follow the following
two paths:  or . The first path takes jumps while the second takes .

Function Description

Complete the jumpingOnClouds function in the editor below. It should return the minimum number
of jumps required, as an integer.

jumpingOnClouds has the following parameter(s):

c: an array of binary integers
Input Format

The first line contains an integer , the total number of clouds. The second line contains
space-separated binary integers describing clouds  where .

Constraints

Output Format

Print the minimum number of jumps needed to win the game.

Sample Input 0

7
0 0 1 0 0 1 0
Sample Output 0

4
 */
public class JumpingOnClouds {
    static int jumpingOnCloudsSol1(int[] c) {
        if(c.length <2 || 1== c[0])
            return 0;

        int count = -1;
        for (int i = 0; i < c.length; i++, count++) {
            if (i<c.length-2 && c[i+2]==0) i++;
        }
        System.out.println(count);

    return 0;
 }

    static int jumpingOnCloudsSol2(int[] c) {
        int jumps =0;
        int i=0;
        while (i<c.length-1){
            if(i+2 ==c.length || c[i+2]==1){
                jumps++;
                i++;
            }else{
                i+=2;
                jumps++;
            }
        }
        System.out.println(jumps);
        return jumps;
    }

    public static void main(String[] args) {
        int a[] = new int[]{0,0,0,1,0,0,1,0,0};
        JumpingOnClouds.jumpingOnCloudsSol1(a);
        JumpingOnClouds.jumpingOnCloudsSol2(a);
    }

}

