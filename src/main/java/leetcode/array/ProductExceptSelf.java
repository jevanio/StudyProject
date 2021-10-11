package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductExceptSelf {
    public int[] productExceptSelfV1(int[] nums) {
        int[] productArray = new int[nums.length];
        Arrays.fill(productArray, 1);

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            for (int j = 0; j < productArray.length; j++) {
                if (i != j) {
                    productArray[j] *= element;
                }
            }
        }
        return productArray;
    }

    public int[] productExceptSelfV2(int[] nums) {
        Map<Integer, Integer> productMap = new HashMap<>();
        int[] productArray = new int[nums.length];
        Arrays.fill(productArray, 1);

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (productMap.containsKey(element)) {
                productArray[i] = productMap.get(element);
            } else {
                productArray[i] = product(nums, i);
                productMap.put(element, productArray[i]);
            }

        }
        return productArray;
    }

    private Integer product(int[] nums, int pos) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != pos) {
                product *= nums[i];
            }
        }

        return product;
    }
}
