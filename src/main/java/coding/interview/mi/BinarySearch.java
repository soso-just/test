package coding.interview.mi;

public class BinarySearch {

    public static int binarySearch(int[] array, int num){
        if (array == null || array.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = array.length -1;
        return binarySearch(array,begin,end,num);

    }

    private static int binarySearch(int[] array, int begin, int end, int num) {
        if (begin > end) {
            return -1;
        }
        int index = (begin + end)>>1;
        if (array[index] == num) {
            return index;
        }else {
            if (array[index] < num) {
                return  binarySearch(array,index+1, end, num);
            }else {
                return  binarySearch(array,begin, index-1, num);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,6,9,10};
        System.out.println(binarySearch(array, 3));
    }


}
