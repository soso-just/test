package coding.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @link https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @desc
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class TranslateNum {

    public static int translateNum(int num) {
        if (num< 0) {
            return 0;
        }
        String numString =  String.valueOf(num);
        int beginIndex = 0;
//        return (translateNum(numString, beginIndex));
        HashMap<String, Integer>  cache = new HashMap<>();
        return (translateNumAddCache(numString, beginIndex,cache));
    }

    private  static int translateNum(String numString, int beginIndex) {
        if (beginIndex == numString.length()-1) {
            return 1;
        }
        char c1 = numString.charAt(beginIndex);
        Character c2 = null;
        if (beginIndex < numString.length()-1) {
            c2 = numString.charAt(beginIndex+1);
        }
        if (c1 > '2' || (c1 == '2' && c2 != null && c2 > '5')) {
            return translateNum(numString, beginIndex+1);
        }else if(c1=='0') {
            return translateNum(numString, beginIndex+1);
        }else {
            if (beginIndex == numString.length()-2) {
                return 2;
            }
            return translateNum(numString, beginIndex+1)+
                    translateNum(numString, beginIndex+2);
        }
    }

    private  static int translateNumAddCache(String numString, int beginIndex, Map<String, Integer> cache) {
        String cacheStr =  numString.substring(beginIndex);
        if (cache.containsKey(cacheStr)) {
            return cache.get(cacheStr);
        }
        if (beginIndex == numString.length()-1) {
            cache.put(cacheStr, 1);
            return 1;
        }
        char c1 = numString.charAt(beginIndex);
        Character c2 = null;
        if (beginIndex < numString.length()-1) {
            c2 = numString.charAt(beginIndex+1);
        }

        int result = 0;
        if (c1 > '2' || (c1 == '2' && c2 != null && c2 > '5')) {
            result = translateNum(numString, beginIndex+1);
        }else if(c1=='0') {
            result = translateNum(numString, beginIndex+1);
        }else {
            if (beginIndex == numString.length()-2) {
                cache.put(cacheStr, 2);
                return 2;
            }
            result =  translateNum(numString, beginIndex+1)+
                    translateNum(numString, beginIndex+2);
        }
        cache.put(cacheStr, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(translateNum(2022222222));
    }

}
