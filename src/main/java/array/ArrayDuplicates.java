package array;

public class ArrayDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return ++k;
    }

    public int simpleRemoveElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public int removeValue(int[] nums, int value) {
        if (nums.length == 0) {
            return 0;
        }

        int k=nums.length;
        int last = nums.length;
        for(int i=0;i< nums.length; i++) {
            if(nums[i] == value) {
                last = getLastDiff(nums, value, last);
                nums[i] = nums[last];
                k--;
            }
        }

        return k;
    }

    private int getLastDiff(int[] nums, int value, int last) {
        for(int i=last-1; i>0;i--) {
            if (nums[i] != value) {
                return i;
            }
        }
        return 0;
    }
}
