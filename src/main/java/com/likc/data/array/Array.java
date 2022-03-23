package com.likc.data.array;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * @author likc
 * @date 2022/3/23
 * @description
 */
public class Array {
        /*两数之和等于target，返回两数数组下标*/
        int[] sumOfTwoNum(int[] nums){
            int target = 5;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int i = 0; i< nums.length; i++) {
                if (hashMap.containsKey(target - nums[i])) {
                    return (new int[]{hashMap.get(target-nums[i]), i});
                }
                hashMap.put(nums[i], i);
            }
            return null;
        }

        /*最长公共前缀*/
        String longPrefix(String[] strs){
            if (strs == null || strs.length == 0) {
                return " ";
            }

            String prefix = strs[0];

            for (int i = 1; i <strs.length; i++ ) {
                int min = Math.min(prefix.length(), strs[i].length());
                int index = 0;
                while (index < min && prefix.charAt(index) == strs[i].charAt(index)) {
                    index++;
                }
                prefix = prefix.substring(0, index);
            }
            return prefix;
        }

        /*删除数组重复项，返回新数组长度，不考虑新长度后面的数组*/
        int deletRepeatArray(int[] nums){
            if(nums == null || nums.length == 0) {
                return 0;
            }

            int s = 0;
            int x = 1;

            while(x < nums.length) {
                if(nums[s] != nums[x]) {
                    nums[s+1] = nums[x];
                    s++;
                }
                x++;
            }
            return s+1;
        }

        /*给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度*/
        int removeElement(int[] nums, int val) {
            if(nums == null || nums.length == 0) {
                return 0;
            }

            int left = 0;
            int right = 0;

            while(right < nums.length){
                if(nums[right] != val){
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
            return left;
        }

        /*输入的字符串反转过来，输入字符串以字符数组的形式给出*/
        void reverseString(char[] s) {
            int n = s.length;
            for(int left = 0, right = n - 1 ; left < right; left++, right--){
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
        }

        /*给定一个含有n个正整数的数组和一个正整数 target 。
        找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0*/
        int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int sum = 0;
            int result = Integer.MAX_VALUE;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    result = Math.min(result, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }

        /**
         *  超大整数相加
         * @param strs
         * @return
         */
        BigInteger sumBigInt(String[] strs){
            BigInteger bigInteger1 = new BigInteger(strs[0]);
            BigInteger bigInteger2 = new BigInteger(strs[1]);

            BigInteger add = bigInteger1.add(bigInteger2);

            System.out.println(add);
            return null;
        }

        /**
         *  找出数组中任意一个重复的数字-O(1)空间复杂度实现
         */
        int repeatInt(int[] nums){
            for (int i = 0; i < nums.length; i++){
                while (nums[i] != i){
                    if (nums[i] == nums[nums[i]]){
                        return nums[i];
                    }else {
                        int temp = nums[i];
                        nums[i] = nums[nums[i]];
                        nums[temp] = temp;
                    }
                }
            }
            return 0;
        }

    public static void mian(String args[]){

    }
}
