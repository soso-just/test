package coding.interview.niuke;

import java.util.HashSet;
import java.util.Set;

/**
 *  给出一个数组，返回未在数组中的最小正整数。demo: {13,6,2,6,3}  返回：4要求时间复杂度为O(n)
 */
public class GetMax {

    public int getMex(int[] A, int n) {
        Set<Integer> cacheSet = new HashSet<Integer>(A.length);
        for (int i= 0; i < A.length; i++){
            cacheSet.add(A[i]);
        }
        int result = 1;
        while (true){
            if (cacheSet.contains(result)) {
                result++;
            }else{
                return result;
            }
        }
    }
}
