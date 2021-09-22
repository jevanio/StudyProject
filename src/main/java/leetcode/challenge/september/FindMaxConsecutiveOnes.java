package leetcode.challenge.september;

public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        if (nums.length == 0) {
            return maxCount;
        } else {
            int actualCount = 0;
            for (int num : nums) {
                if (num == 1) {
                    actualCount++;
                } else {
                    maxCount = getMaxCount(maxCount, actualCount);
                    actualCount = 0;
                }
            }
            return getMaxCount(maxCount, actualCount);
        }
    }

    private int getMaxCount(int maxCount, int actualCount) {
        return Math.max(actualCount, maxCount);
    }
}
