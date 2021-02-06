package ru.education.algorithm;

import java.util.Arrays;

public class Algorithm {
    /////////////////////////////////////////////////////
    //Побочное задание
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1 || target == 0) {
            return null;
        }
        int i = 0;
        int x = 0;
        do {

            int sum = nums[x] + nums[nums.length - 1 - i];
            if (sum == target && nums[x] != nums[nums.length - 1 - i]) {
                int y = nums.length - 1 - i;
                return new int[]{x, y};
            } else if (sum != target && nums[x] != nums[nums.length - 1 - i]) {
                x++;
            } else {

                x = 0;
                i++;
            }

        }
        while (nums.length - 1 - i > 0);
        return null;
    }


    public int[] anotherTwoSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1 || target == 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {

            int sum = target - nums[i];
            int index = Arrays.binarySearch(nums, sum);
            if (index < 0)
                continue;
            if (nums[index] + nums[i] == target) {
                return new int[]{index, i};
            }
        }

        return null;

    }
}
