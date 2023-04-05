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

    public static int lengthOfLongestSubstring(String s) {
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

    public static int reverse(int x) {
        boolean negative = false;
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            x = -x;
            negative = true;
        }
        int t;
        int out = -1;
        while (x >= 10) {
            t = x % 10;
            if (out != -1) {
                out = out*10 + t;
                x = x / 10;
            }
            if (out == -1) {
                if (t != 0) {
                    out = t;
                }
                x = x / 10;
            }
        }
        if (out >= 300_000_000) {
            return 0;
        }
        if (negative) {
            if (out == -1) {
                return -x;
            }
            out = -10*out - x;
            return Math.min(out, 0);
        } else {
            if (out == -1) {
                return x;
            }
            out = 10*out + x;
            return Math.max(out, 0);
        }
    }

}
