package coding.leetcode.array;

public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res1 = 0, res2 =nums[0];
        for (int i=1; i< nums.length; ++i){
            if ((i & 1) ==0) {
                res2+=nums[i];
            }else {
                res1+=nums[i];
            }
        }
        return Math.max(res1, res2);
    }
}
