package ru.education.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayCalculate {

    public final int[] numbers;


    public ArrayCalculate(int index) {
        numbers = new int[index];
        Random random = new Random();
        for (int i = 0; i < index; i++) {
            numbers[i] = random.nextInt(1000);
        }
        System.out.println("Init array:" + Arrays.toString(numbers));

    }

    public ArrayCalculate(int[] nums) {
        numbers = nums;
    }


    public Integer sum() {
        if (numbers.length == 0) {
            return null;
        }
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        return sum;
    }


    public Integer max() {
        Integer maxNumber = null;
        //[0,3,1,4]
        // max = null
        // [0] max = 0
        // [3] max > [3] max=3
        //[1] max > [1] max = 3
        // [4] max > [4] max = 4
        // return max 4
        for (Integer x : numbers) {
            if (maxNumber == null) {
                maxNumber = x;
            } else {
                if (x > maxNumber) {
                    maxNumber = x;
                }
            }
        }
        return maxNumber;
    }


    public Integer middle() {
        if (numbers.length % 2 == 0) {
            return null;
        } else {
            return numbers[numbers.length / 2];
        }
    }

    public int[] revers() {
        int[] result = new int[numbers.length];
        // [33,23,33]
        // [,,]
        // [33]  0 [33,,]
        // [23]  1 [33,23,]
        // [43]  2 [33,23,43]
        // return [33,23,43]
        int k = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            result[k++] = numbers[i];
        }
        return result;
    }



/////////////////////////////////////////////////////
    //Побочное задание
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0||nums.length == 1||target==0) {
            return null;
        }
        int i = 0;
        int x = 0;
        do {

            int sum = nums[x] + nums[nums.length - 1 - i];
            if (sum == target && nums[x] != nums[nums.length - 1 - i]) {
                int y = nums.length - 1 - i;
                 return new int[]{x,y};
            } else if (sum != target && nums[x] != nums[nums.length - 1 - i]) {
                x++;
            } else {
                
                x = 0;
                i++;
            }

        }
        while (nums.length - 1 - i >0);
        return null;
    }





    public int[] anotherTwoSum(int[] nums, int target) {
        if (nums.length == 0||nums.length == 1||target==0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {

            int sum = target - nums[i];
            int index = Arrays.binarySearch(nums, sum);
            if(index<0)
                continue;
             if (nums[index] + nums[i] == target) {
                return new int[]{index,i};
            }
        }

        return null;

    }
}
