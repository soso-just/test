package coding.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 未解决
 */
public class CountSmaller {

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Integer[] result = new Integer[nums.length];
        result[nums.length-1] =0;

        for (int i=(nums.length-2); i>=0; i--){
            int currentNum = nums[i];
            int count = 0;
            for (int j = i+1; j< nums.length; j++){
                if (currentNum>nums[j]) {
                    count++;
                }
            }
            result[i]=count;
        }
        return Arrays.asList(result);
    }


    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }
}
