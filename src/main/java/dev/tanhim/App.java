package dev.tanhim;

import java.util.*;

public class App 
{
    // -------------------  data structures and utility classes  ------------------- //
    class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; };
        ListNode(int val, ListNode next) { this.val = val; this.next = next; };

        // sorted insert for insertion sort
        public ListNode sortedInsert(ListNode head, ListNode newNode) {
            ListNode dummy = new ListNode(); 
            ListNode current = head;
            dummy.next = head;
    
            while (current.next != null && current.next.val < newNode.val) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
    
            return dummy.next;
        }
    }


    // -------------------  practice problems start here  ------------------- //
    /* leetcode 1: two sum
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                int sumTwo = target - nums[i];
                if(nums[j] == sumTwo) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("solution does not exist");
    }


    /* leetcode 3: longest substring without repeating characters
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s == null || s.isEmpty())
            return 0;

        Map<Character, Integer> substring = new HashMap<>();           
        for(int i=0; i<s.length(); i++) {
            if(!substring.containsKey(s.charAt(i))) {
                substring.put(s.charAt(i), i);
                
                // update max length based on current substring
                if (substring.size() > maxLength) {
                    maxLength = substring.size();
                }
            } else {
                substring.clear();

            }
        }        
        
        return maxLength;
    }


    /* leetcode 26: remove duplicates from array
     *
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     *              It does not matter what you leave beyond the returned k (hence they are underscores).
     */
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


    /* leetcode 27: remove element from array
     *
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2
     * Output: 5, nums = [0,1,4,0,3,_,_,_]
     */
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


    /* leetcode 45: jump game 2
     * 
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */
    public static int canJumpCount(int[] nums) {
        int target = nums.length-1;
        int jumps = 0;
        int range = 0;
        int farthest = 0;

        for (int i=0; i < target; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= target) {
                ++jumps;
                break;
            }
            if (i == range) {
                ++jumps;
                range = farthest;
            }
        }
        
        return jumps;
    }


    /* leetcode 55: jump game
     * 
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * */
    public static boolean canJump(int[] nums) {
        int index = 0;
        for (int i=0; i < nums.length; i++) {
            if(i > index)
                return false;
            index = Math.max(index, i + nums[i]);
        }
        return true;
    }


    /* leetcode 80: remove duplicates from sorted array II
     *
     * Input: nums = [1,1,1,2,2,3]
     * Output:  5, nums = [1,1,2,2,3,_]
     */
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


    /* leetcode 80: remove duplicates from sorted array II
     * *** better solution ***
     *
     * Input: nums = [1,1,1,2,2,3]
     * Output:  5, nums = [1,1,2,2,3,_]
     */
    public static int removeDuplicatesTwoBetter(int[] nums) {
        int i = 0;

        for (final int num : nums)
            if (i < 2 || num > nums[i - 2])
                nums[i++] = num;

        return i;
    }


    /* leetcode 88: merge sorted aray
     *
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for (int i=m; i < m+n; i++) {
            nums1[i] = nums2[index];
            index++;
        }
        Arrays.sort(nums1);
    }


    /* leetcode 121: best time to buy and sell stock
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     */
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


    /* leetcode 121: best time to buy and sell stock
     * *** better solition ***
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     */
    public static int maxProfitBetter(int[] prices) {
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

    
    /* leetcode 122: best time to buy and sell stock II
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     */
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


    /* leetcode 125: valid palindrome
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        char[] chars = s.toCharArray();
        char[] rev = new char[chars.length];
        int index = chars.length-1;

        for (char c : chars) {
            rev[index] = c;
            index--;
        }

        return Arrays.toString(chars).equals(Arrays.toString(rev));
    }


    /* leetcode 141: linked list cycle
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     */
    public static boolean hasCycle(ListNode head) {
        int pos = -1;
        ListNode traversed = head; // mark nodes travelled with a value greater than 10^5
        ListNode current = traversed;
        ListNode next;
        boolean hasCycle = false;

        if (head == null || head.next == null)
            return false;


        while (current.next != null) {
            if (current.val >= 100001) {
                hasCycle = true;
                break;
            }

            next = current.next;
            current.val = 100001 + ++pos;  // pos can be recalculated from offset
            current = next;
        }
        
        return hasCycle;
    }


    /* leetcode 148: sort linked list in ascending order
     *
     * Input: head = [4,2,1,3]
     * Output: [1,2,3,4]
     */
    public static ListNode sortList(ListNode head) {
        ListNode result = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            result = result.sortedInsert(result, current);
            current = next;
        }

        return result;
    }
    

    /* leetcode 169: majority element in array
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }


    /* leetcode 189: rotate array by k steps
     *
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     */
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


    // -------------------  run/debug  ------------------- //
    public static void main( String[] args )
    {

    }
}
