package com.likc.data.bit;

/**
 * @author likc
 * @date 2022/3/23
 * @description
 */

public class Bit {

        /**
         *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
         *  ^ 异或运算
         *  任何数和 0做异或运算，结果仍然是原来的数。 a^0 = a
         *  任何数和其自身做异或运算，结果是 0. a^a = 0
         *  异或运算满足交换律和结合律。 a^b^a = b^a^a = b^0 = b
         * @param nums
         * @return
         */
        int singleNumber(int[] nums) {
            int res = 0;
            for(int i : nums){
                res ^= i;
            }
            return res;
        }

        /**
         *  编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）
         *  n & n-1 消除二进制最右边的一
         * @param n
         * @return
         */
        int hammingWeight(int n) {
            int res = 0;
            while(n != 0){
                n &= n-1;
                res++;
            }
            return res;
        }


    public static void main(String[] args) {

    }
}
