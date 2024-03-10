package dev.tanhim;

import java.util.Arrays;


public class App 
{
    // leetcode 26
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int dupeCount = 0;

        while (index < nums.length-1) {
            if (nums[index] == nums[index+1]) {
                dupeCount++;
                nums[index] = 101;
            }
            index++;
        }
        Arrays.sort(nums);

        return nums.length - dupeCount;
    }

    // leetcode 27
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int k = nums.length;

        for (int i=0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 101;
                k--;
            }
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        return k;
    }


    // leetcode 121  ---> my solution
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        if (prices.length <= 1)
            return maxProfit;

        for(int i=0; i<prices.length; i++) {
            for(int j=i; j<prices.length; j++) {
                int potential = prices[j] - prices[i];
                if (potential > maxProfit) {
                    maxProfit = potential;
                }
            }
        }

        return maxProfit;
    }

    // leetcode 121 ---> optimal solition
    public static int maxProfitOptimal(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {
            int potential = prices[right] - prices[left];

            if (prices[left] > prices[right]) {
                left = right;
            } else {
                maxProfit = Math.max(maxProfit, potential);
            }
            right++;
        }
        return maxProfit;
    }

    // leetcode 122
    public static int maxProfitMultipleTrades(int[] prices) {
        int left = 0;
        int right = 1;
        int totalProfit = 0;

        while (right < prices.length) {
            int potential = prices[right] - prices[left];
            if (prices[left] > prices[right]) {
                left = right;
            } else {
                totalProfit += potential;
                left = right;
            }
            right++;
        }

        return totalProfit;
    }
    

    public static void main( String[] args )
    {
        // leetcode test cases (convert these to junit cases and publish to github)
        // ===================================================
        // 26)
        // int[] nums = {1,1,2};
        // int uniqueNums = removeDuplicates(nums);
        // int nums2[] = {0,0,1,1,1,2,2,3,3,4,5};
        // int uniqueNums2 = removeDuplicates(nums2);
        // System.out.println(uniqueNums);
        // System.out.println(uniqueNums2);

        // ===================================================
        // 27)
        // int[] nums = { 3,2,2,3, 0, 1, 34, 2, 3 };
        // int[] nums2 = { 3,2,2,3 };
        // int r2 = removeElement(nums, 2);
        // int r3 = removeElement(nums2, 3);
        // System.out.println(r2);
        // System.out.println(r3);

        // ===================================================
        // 121)
        // Input: prices = [7,1,5,3,6,4]
        // Output: 5
        // int[] prices = {7,1,5,3,6,4};
        // int[] prices2 = {7,6,4,3,1};
        // System.out.println(maxProfitOptimal(prices));
        // System.out.println(maxProfitOptimal(prices2));

        // ===================================================
        // 122)
        // Input: prices = [7,1,5,3,6,4]
        // Output: 7
        // int[] prices = {7,1,5,3,6,4};
        // System.out.println(maxProfitMultipleTrades(prices));


    }
}
