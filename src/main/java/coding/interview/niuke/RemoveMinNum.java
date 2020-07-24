package coding.interview.niuke;

/**
 * 给一个无序数组（元素固定 1-n连续），求解：变成有序数组，需要移动元素的最小个数，demo: {1,3,2,4} 返回1
 * 首位固定是1
 */
public class RemoveMinNum {

    public static int removeMinNum(int[] array){
        int removeNum = 0;
        for (int i=1; i< array.length; i++){
            if (array[i] != (i+1)) {
                for (int j= i+1; j< array.length; j++ ){
                    if (array[j] == (i+1)) {
                        //交换
                        int tempNum = array[j];
                        array[j] = array[i];
                        array[i] = tempNum;
                        removeNum++;
                    }
                }
            }
        }
        return removeNum;
    }

    public static void main(String[] args) {
        int[] array = {1,3,2,4};
        System.out.println(removeMinNum(array));
        int[] array1 = {1,3,4,2};
        System.out.println(removeMinNum(array1));
    }

}
