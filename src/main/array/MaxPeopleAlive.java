package main.array;


/*Steps of the algorithm
1.Construct an array X of 100 integers (all initialized to zero; 101 integers if the year 2000 is included).
2.For each of the N people, increment X[birth year - 1900] by one and decrement X[death year - 1900] by one.
3.Iterate through X, maintaining a sum of each element as you go. The year with the most people alive is 1900 plus the
index where the sum is maximum.*/

import java.util.Arrays;

public class MaxPeopleAlive {
    static int maxPersonAliveInYear(int[] birthDates, int[] deathdates) {
        int minBirthDate = getMinValue(birthDates);
        int maxDeathDate = getMaxValue(deathdates);
        int tempArr[] = new int[(maxDeathDate - minBirthDate) + 1];
        Arrays.fill(tempArr, 0);
        for (int i = 0; i < birthDates.length; i++) {
            tempArr[birthDates[i] - minBirthDate]++;
            tempArr[deathdates[i] - minBirthDate]--;
        }

        int population = 0;
        int max_population = 0;
        int max_population_index = 0;
        for (int i = 0; i < tempArr.length; i++) {

            population += tempArr[i];
            if (population > max_population) {
                max_population = population;
                max_population_index = i;
            }
        }
        return max_population_index + minBirthDate;
    }

    public static int getMaxValue(int[] numbers) {
        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    public static int getMinValue(int[] numbers) {
        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        int[] birthDates = {1990, 1995, 1997, 2000, 2005};
        int[] deathdates = {2046, 2045, 2055, 2050, 2017};
        System.out.println(maxPersonAliveInYear(birthDates, deathdates));
    }
}
