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
    // int[] nums = { 3,2,2,3, 0, 1, 34, 2, 3 };
    // int[] nums2 = { 3,2,2,3 };
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
        return k;
    }

    // leetcode 50
    public static boolean canJump(int[] nums) {
        


        return false;
    }

    // leetcode 80
    // Input: nums = [1,1,1,2,2,3]
    // Output: 5, nums = [1,1,2,2,3,_]
    public static int removeDuplicatesTwo(int[] nums) {
        int current = nums[0];
        int count = 1;
        int k = nums.length;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] == current) {
                count++;
                if (count > 2) {
                    nums[i] = 10001;
                    k--;
                }
            } else {
                count = 1;
                current = nums[i];
            }
        }

        Arrays.sort(nums);
        return k;
    }

    // leetcode 80
    // Input: nums = [1,1,1,2,2,3]
    // Output: 5, nums = [1,1,2,2,3,_]
    public static int removeDuplicatesTwoBetter(int[] nums) {
        int i = 0;

        for (final int num : nums)
            if (i < 2 || num > nums[i - 2])
                nums[i++] = num;

        return i;
    }
    // leetcode 88
    // Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    // Output: [1,2,2,3,5,6]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for (int i=m; i < m+n; i++) {
            nums1[i] = nums2[index];
            index++;
        }
        Arrays.sort(nums1);
    }

    // leetcode 121  ---> my solution
    // Input: prices = [7,1,5,3,6,4]
    // Output: 5
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
    // Input: prices = [7,1,5,3,6,4]
    // Output: 5
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
    // Input: prices = [7,1,5,3,6,4]
    // Output: 7
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

    // leetcode 169
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }

    // leetcode 189
    // Input: nums = [1,2,3,4,5,6,7], k = 3
    // Output: [5,6,7,1,2,3,4]
    public static void rotate(int[] nums, int k) {        
        k = k % nums.length;
        if (k < 0) {
            k += nums.length;
        }  
        reverse(nums, 0 , nums.length - k -1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }
    public static void reverse(int[] nums, int i, int j) {
        int left = i;
        int right = j;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums [right];
            nums[right] = temp;

            left++;
            right--;
        }
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
        // 88)
        // Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // Output: [1,2,2,3,5,6]
        //
        // int[] nums1 = { 1,2,3,0,0,0 };
        // int[] nums2 = { 2,5,6 };
        // merge(nums1, 3, nums2, 3);
        // System.out.println(Arrays.toString(nums1));
        
        // ===================================================
        // 121)
        // Input: prices = [7,1,5,3,6,4]
        // Output: 5
        //
        // int[] prices = {7,1,5,3,6,4};
        // int[] prices2 = {7,6,4,3,1};
        // System.out.println(maxProfitOptimal(prices));
        // System.out.println(maxProfitOptimal(prices2));

        // ===================================================
        // 122)
        // Input: prices = [7,1,5,3,6,4]
        // Output: 7
        //
        // int[] prices = {7,1,5,3,6,4};
        // System.out.println(maxProfitMultipleTrades(prices));

    }
}
