package com.likc.data.dfs;

import java.util.*;

/**
 * @author likc
 * @date 2022/3/23
 * @description
 */

public class Dfss {
        /*
         *
         * 全排列
         * 状态变量：递归到第几层    depth
         *         已经选了什么数  path
         *         布尔数组       used
         * */
        List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            Deque<Integer> path = new ArrayDeque<>();
            boolean[] used = new boolean[len];
            dfs(nums, len, 0, used, path, res);
            return res;
        }
        private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
            if (depth == len){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (used[i]){
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, used, path, res);
                path.removeLast();
                used[i] = false;
            }
        }

        /**
         *  求子集
         *  给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
         * @param nums
         * @return
         */
        List<List<Integer>> subsets(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> path = new LinkedList<>();
            dfs(nums, len, 0, path, res);
            return res;
        }
        private void dfs(int[] nums, int len, int begin, Deque<Integer> path, List<List<Integer>> res) {
            res.add(new ArrayList<>(path));
            for (int i = begin; i < len; i++) {
                path.addFirst(nums[i]);
                dfs(nums, len, i+1, path, res);
                path.removeFirst();
            }
        }

}
