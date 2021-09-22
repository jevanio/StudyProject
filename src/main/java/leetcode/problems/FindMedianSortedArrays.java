package leetcode.problems;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int maxLength = nums1.length + nums2.length;
        if (maxLength == 0) {
            return 0.0000;
        }
        int[] mergedNums = new int[maxLength];
        int i = 0;
        int j = 0;
        int pos = 0;

        while (pos < maxLength) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i = addNum(nums1, mergedNums, i, pos);
                } else {
                    j = addNum(nums2, mergedNums, j, pos);
                }
            } else if (i < nums1.length) {
                i = addNum(nums1, mergedNums, i, pos);
            } else {
                j = addNum(nums2, mergedNums, j, pos);
            }
            pos++;
        }
        return arrayMedian(mergedNums);
    }

    private int addNum(int[] nums, int[] mergedNums, int numPosition, int pos) {
        mergedNums[pos] = nums[numPosition];
        numPosition++;
        return numPosition;
    }

    private double arrayMedian(int[] mergedNums) {
        if (mergedNums.length % 2 == 1) {
            return mergedNums[mergedNums.length / 2];
        } else {
            return (mergedNums[mergedNums.length / 2] + mergedNums[(mergedNums.length - 1) / 2]) / 2d;
        }
    }
}
