package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class HashSetApplications {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        return set.stream().findFirst().orElse(-1);
    }

    public int singleNumberLambda(int[] nums) {
        Map<Integer, Long> collect = Arrays.stream(nums).boxed().collect(groupingBy(Function.identity(), counting()));
        for (Map.Entry map : collect.entrySet()) {
            if (Integer.parseInt(String.valueOf(map.getValue())) == 1) {
                return Integer.parseInt(String.valueOf(map.getKey()));
            }
        }
        return -1;
    }

    public int singleNumberLambdaV2(int[] nums) {
        Map<Integer, Integer> collect = new HashMap<>();
        for (int n : nums) {
            if (collect.containsKey(n)) {
                collect.put(n, collect.get(n) + 1);
            } else {
                collect.put(n, 1);
            }
        }
        for (Map.Entry<Integer, Integer> map : collect.entrySet()) {
            if (map.getValue() == 1) {
                return map.getKey();
            }
        }
        return -1;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) {
                    set.add(k);
                    break;
                }
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersectionV2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        int actualValue = nums1[0], i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
            }

            if (nums1[i] < nums2[j]) {
                actualValue = nums1[i];
                i++;
            } else {
                actualValue = nums2[j];
                j++;
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    Map<Integer, Integer> map = new HashMap<>();

    public boolean isHappy(int n) {
        Set<Integer> squareSumMap = new HashSet<>();
        do {
            n = sumSquareRecursive(n);
            if (squareSumMap.contains(n)) {
                return false;
            }
            squareSumMap.add(n);
        } while (n != 1);
        return true;
    }

    private int sumSquareRecursive(int n) {
        int module = n % 10;
        int division = n / 10;
        if (division == 0) {
            return module * module;
        }
        return sumSquareRecursive(division) + (module * module);
    }

    private int sumSquare(int n) {
        int sum = 0;
        int value = n;
        while (value > 0) {
            int key = value % 10;
            int square = key * key;
            sum += square;
            value /= 10;
        }
        return sum;
    }

}
