package coding.interview.bee;

import java.util.*;

/**
 * 数组全排列
 * 给定一个数字的序列，返回其所有可能的全排列。
 *  
 * 输入: [1,2,3]输出:[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
 */
public class Demo {

    public static void getAll(int[] array){
        getAll(array,"");
    }

    private static  void getAll(int[] array, String prefix) {
        if (array.length == 1) {
            System.out.println(prefix+","+array[0]);
            return;
        }

        for (int i=0; i <array.length; i++ ){
            String newPrefix = prefix;
            if (prefix == "") {
                newPrefix += array[i];
            }else {
                newPrefix +=(","+array[i]);
            }
            int[] newArray = getNewArray(array, i);
            getAll(newArray, newPrefix);
        }
    }

    private static int[] getNewArray(int[] array, int removeIndex) {
        int[] result = new int[array.length-1];
        for (int i= 0; i < array.length-1; i++ ){
            if (i< removeIndex) {
                result[i]= array[i];
            }else {
                result[i]=array[i+1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        getAll(array);
    }

}

