package array;

import java.util.Arrays;

public class ArrayNumber {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 2};
        int minOutArray = getMinOutArray(array);
        System.out.println(minOutArray);
        int N = 134;
        System.out.println("sumDigits result of " + N + ": " + sumDigits(N));

    }

    private static int sumDigits(int number) {
        int sum = 0;
        int resto = 0;
        while (number > 0) {
            sum+=number%10;
            number = number/10;
        }
        return sum;
    }

    private static int getMinOutArray(int[] array) {
        int min = 1;
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        for (int i : sortedArray) {
            if (min == i) {
                min += 1;
            } else if (min < i) {
                break;
            }
        }
        return min;
    }
}
