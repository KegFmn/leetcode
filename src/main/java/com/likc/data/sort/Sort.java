package com.likc.data.sort;

/**
 * @author likc
 * @date 2022/3/23
 * @description
 */

public class Sort {

        /**
         * 使用递归的二分查找
         *title:recursionBinarySearch
         *@param ints 升序数组
         *@param key 待查找关键字
         *@return 找到的位置
         */
        int binarySearch(int[] ints, int key, int low, int high){
            if (key < ints[low] || key > ints[high] || low > high){
                return -1;
            }

            int middle = (low + high) / 2;
            if (ints[middle] > key){
                return binarySearch(ints , key, low, middle-1);
            } else if (ints[middle] < key){
                return binarySearch(ints, key, middle+1, high);
            } else {
                return middle;
            }
        }

        /*冒泡排序*/
        int[] bubbingSort(int[] nums){
            if (nums.length == 0 || nums == null){
                return null;
            }

            int temp = 0;
            for (int i = 0; i < nums.length-1; i++){
                for (int j = 0; j < nums.length-1-i; j++){
                    if (nums[j] > nums[j+1]){
                        temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }
            }
            return nums;
        }

        /*递归快速排序*/
        int[] fastSort(int[] nums, int left, int right){
            int i, j, t, temp;
            if(left > right){
                return null;
            }

            temp = nums[left]; //temp中存的就是基准数
            i = left;
            j = right;
            while(i != j) { //顺序很重要，要先从右边开始找
                while(nums[j] >= temp && i < j)
                    j--;
                while(nums[i] <= temp && i < j)//再找右边的
                    i++;
                if(i < j)//交换两个数在数组中的位置
                {
                    t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            //最终将基准数归位
            nums[left] = nums[i];
            nums[i] = temp;
            fastSort(nums, left, i-1); //继续处理左边的，这里是一个递归的过程
            fastSort(nums,i+1, right); //继续处理右边的 ，这里是一个递归的过程
            return nums;
        }

}
