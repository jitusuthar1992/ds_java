package main.array;

import java.util.Arrays;

/*
Given an array of elements of length N,
ranging from 0 to N – 1. All elements
may not be present in the array. If
element is not present then there will
be -1 present in the array. Rearrange
the array such that A[i] = i and if i
is not present, display -1 at that place.
 */
public class RearrangeArray {

    public static int[] fix(int[] A)
    {
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] != -1 && A[i] != i)
            {
                int x = A[i];

                // check if desired place
                // is not vacate
                while (A[x] != -1 && A[x] != x)
                {

                    // store the value from
                    // desired place
                    int y = A[x];

                    // place the x to its correct
                    // position
                    A[x] = x;

                    // now y will become x, now
                    // search the place for x
                    x = y;
                }

                // place the x to its correct
                // position
                A[x] = x;

                // check if while loop hasn't
                // set the correct value at A[i]
                if (A[i] != i)
                {

                    // if not then put -1 at
                    // the vacated place
                    A[i] = -1;
                }
            }
        }
        return A;
    }

    // Driver function.
    public static void main(String[] args)
    {
        int A[] = {-1, -1, 6, 1,
                9, 3, 2, -1, 4,-1};
        System.out.println(Arrays.toString(fix(A)));

    }

}
