package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayString {
    public static void main(String[] args) {
        String[] cars = {"100", "110", "010", "011", "100"};
        int[] ints = countDiff(cars);
        System.out.println("Number of similars: " + Arrays.toString(ints));
    }

    private static int[] countDiff(String[] cars) {
        List<Integer> resultList = new ArrayList<>();
        int[] result = new int[cars.length];
        for(String car: cars) {
            int similarCount = 0;
            for(String otherCar: cars) {
                if (stringDiff(car, otherCar) <= 1) {
                    similarCount++;
                }
            }
            resultList.add(similarCount-1);
        }
        result = resultList.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    private static int stringDiff(String car, String otherCar) {
        char[] carArray = car.toCharArray();
        char[] otherCarArray = otherCar.toCharArray();
        int diffCount = 0;
        int size=car.length();
        for(int i=0; i<size; i++) {
            if (carArray[i] != otherCarArray[i]) {
                diffCount++;
            }
        }
        return diffCount;
    }
}
