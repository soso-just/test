package coding.leetcode.kth;

/**
 * @Link https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @desc 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 */
public class KLargest {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        return findKthLargest(nums,0, nums.length-1, k);

    }

    private static int findKthLargest(int[] nums, int begin, int end, int k) {
        //快排定轴
        int partIndex = getPartionIndex(nums, begin, end);
        if (partIndex == nums.length-k) {
            return nums[partIndex];
        }
        if (partIndex > nums.length-k) {
            return findKthLargest(nums,begin, partIndex-1, k);
        }else {
            return findKthLargest(nums, partIndex+1,end, k);
        }
    }

    private static int getPartionIndex(int[] nums, int begin, int end) {
        //选末尾数（此数在范围内随机选）
        int selectNum = nums[end];
        while (begin < end){
            while (begin < end &&(nums[begin] <= selectNum)) {
                begin++;
            }
            nums[end] = nums[begin];
            while (begin < end &&(nums[end] > selectNum)) {
                end--;
            }
            nums[begin] = nums[end];
        }
        nums[begin] = selectNum;
        return begin;

    }

    public static void main(String[] args) {
        /**
         * [3,2,3,1,2,4,5,5,6]
         */
        int[] array = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(array, 4));

    }

}
