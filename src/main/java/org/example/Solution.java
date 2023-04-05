package org.example;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNode(l1, l2, 0);
    }

    private ListNode addNode(ListNode t1, ListNode t2, int remainder) {
        int rawSum = 0;
        if (t1 != null && t2 != null) {
            rawSum = t1.val + t2.val + remainder;
            return new ListNode(rawSum % 10, addNode(t1.next, t2.next, rawSum / 10));
        } else if (t1 != null && t2 == null) {
            rawSum = t1.val + remainder;
            return new ListNode(rawSum % 10, addNode(t1.next, null, rawSum / 10));
        } else if (t1 == null && t2 != null) {
            rawSum = t2.val + remainder;
            return new ListNode(rawSum % 10, addNode(null, t2.next, rawSum / 10));
        } else {
            if (remainder == 1) {
                return new ListNode(remainder, null);
            } else return null;
        }
    }

    public int lengthOfLongestSubstring(String s) {
        byte[] input = s.getBytes();
        int len = input.length;
        int ml = 0;
        int left = 0;
        int t = 0;
        int cl = 0;
        byte[] b = new byte[96];
        for (int i = 0; i < len; i++) {
            t = input[i] - 32;
            if (b[t] == 0) {
                cl++;
                b[t]++;
                ml = Math.max(ml, cl);
            } else {
                while (b[t] != 0) {
                    b[input[left] - 32] = 0;
                    cl--;
                    left++;
                }
                cl++;
                b[t]++;
            }
        }
        ml = Math.max(ml, cl);
        return ml;
    }
}
