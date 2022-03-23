package com.likc.data.string;

import java.util.*;

/**
 * @author likc
 * @date 2022/3/23
 * @description
 */
public class Strings {

        /*回文数，判断返回boolen*/
        Boolean sameNumberAtBeginningEnd(int num){
            if (num < 0 || (num % 10 == 0 && num != 0)) {
                return false;
            }

            int reverseNumber = 0;
            while (num > reverseNumber) {
                reverseNumber = reverseNumber * 10 + num % 10;
                num /= 10;
            }

            //revertedNumber/10 是为了去除奇数的中位数
            return num == reverseNumber || num == reverseNumber / 10;
        }

        /*有效的括号*/
        Boolean efficientBrackets(java.lang.String s){

            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            HashMap<Character, Character> hashMap = new HashMap<>();
            hashMap.put(')','(');
            hashMap.put('}','{');
            hashMap.put(']','[');

            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                char a = s.charAt(i);
                // hashmap包含弹出，如果栈为空，或者栈的第一个不等于对应的括号则不是有效括号
                if (hashMap.containsKey(a)) {
                    if (stack.isEmpty() || stack.peekFirst() != hashMap.get(a)) {
                        return false;
                    }
                    stack.pollFirst();
                } else {
                    stack.addFirst(a);
                }
            }
            return stack.isEmpty();
        }

        /*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写*/
        boolean isPalindrome(String s) {
            int n = 0;
            int m = s.length() - 1;

            while(n < m){
                // 不是字母和数字直接跳过
                while(n < m && !Character.isLetterOrDigit(s.charAt(n))){
                    n++;
                }
                while(n < m && !Character.isLetterOrDigit(s.charAt(m))){
                    m--;
                }
                if(Character.toLowerCase(s.charAt(n)) != Character.toLowerCase(s.charAt(m)))           {
                    return false;
                }
                n++;
                m--;
            }
            return true;
        }

        /*给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1*/
        int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            // i+m 的意思是匹配到原字符串剩余长度不足匹配字符串时停止
            for (int i = 0; i + m <= n; i++) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }

        /*最长不重复子串*/
        int lengthOfLongestSubstring(String s){
            HashMap<Character, Integer> map = new HashMap<>();
            int maxLen = 0;//用于记录最大不重复子串的长度
            int left = 0;//滑动窗口左指针
            for (int i = 0; i < s.length() ; i++) {
             /*
                 1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
                 此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1(+1是因为i-left是比较的下标+1才是真实长度)，与原来的maxLen比较，取最大值；

                 2、如果当前字符包含在 map中，此时有2类情况：
                 1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
                 那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
                 2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
                 而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
                 随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
                 应该不变，left始终为2，子段变成 ba才对。

                 为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
                 另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
                 因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
                if(map.containsKey(s.charAt(i))) {
                    left = Math.max(left , map.get(s.charAt(i))+1);
                }
                //不管是否更新left，都要更新 s.charAt(i) 的位置！
                map.put(s.charAt(i) , i);
                maxLen = Math.max(maxLen , i-left+1);
            }

            return maxLen;
        }

        /*给你两个二进制字符串，返回它们的和（用二进制表示）*/
        String addBinary(String a, String b){
            if (a == null || a.length() ==0) return b;
            if (b == null || a.length() ==0) return a;

            StringBuffer stb = new StringBuffer();

            int i = a.length()-1;
            int j = b.length()-1;

            int c = 0;
            while (i >= 0 || j >= 0){
                if (i >= 0){
                    c += a.charAt(i--) - '0';
                }
                if (j >= 0){
                    c += b.charAt(j--) - '0';
                }
                // 取余
                stb.append(c % 2);
                // 取整 相当于 /2
                c >>= 1;
            }

            String string = stb.reverse().toString();
            return c > 0 ? "1"+string : string;
        }

        /**
         *  字符串按字段排序，并统计出现次数
         */
        void sortDict(String str){
            str = "fasfasdfa";
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++){
                list.add(str.charAt(i));
            }
            Collections.sort(list);
            Map<Character, Integer> map = new HashMap<>();
            for (Character cha : list){
                if (map.containsKey(cha)){
                    map.put(cha, map.get(cha)+1);
                }else {
                    map.put(cha, 1);
                }
            }

            Set<Map.Entry<Character, Integer>> set = map.entrySet();
            for (Map.Entry entry : set){
                System.out.println("字符:" + entry.getKey() + "出现次数:" + entry.getValue());
            }
        }

        /**
         *   消除相邻相同的字符，最后还有数字就返回true，否则返回false
         * @param str
         * @return
         */
        boolean removeSame(String str){
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < str.length(); i++){
                char chr = str.charAt(i);
                if (!stack.isEmpty()){
                    if (stack.peekFirst() == chr){
                        stack.pollFirst();
                        continue;
                    }
                }
                stack.addFirst(chr);
            }
            return !stack.isEmpty();
        }

    public static void mian(Strings args[]){

    }
}
