package coding.leetcode.array;

/**
 * @link https://leetcode-cn.com/problems/search-insert-position/
 * @desc 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class SearchIndex {

    public int searchInsert(int[] nums, int target) {
        if (nums.length==0) {
            return 0;
        }
        int beginIndex = 0, endIndex = nums.length-1;
        return searchInsert(nums,target,beginIndex,endIndex);
    }

    private int searchInsert(int[] nums, int target, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            if (nums[beginIndex] == target) {
                return beginIndex;
            }else if (nums[beginIndex] > target){
                return beginIndex;
            }else {
                return (beginIndex+1);
            }
        }
        int midIndex = (beginIndex + endIndex) >>1;
        if (nums[midIndex] == target) {
            return midIndex;
        }else  if (nums[midIndex] > target){
            return searchInsert(nums,target,beginIndex,midIndex);
        }else {
            return searchInsert(nums,target,midIndex+1,endIndex);
        }
    }
}
