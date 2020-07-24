package coding.leetcode.string;


import java.util.HashSet;

/**
 * @link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @desc: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstring {


    /**
     * 暴力O(n²)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> cacheSet = new HashSet<Character>();
        int maxLength = 0;
        if (s == null || s.length() == 0) {
            return maxLength;
        }

        for (int i=0; i< s.length(); i++) {
            if (maxLength >=  (s.length()-i)){
                return maxLength;
            }
            for (int j=i; j< s.length();j++){
                if (cacheSet.contains(s.charAt(j))) {
                    break;
                }else {
                    cacheSet.add(s.charAt(j));
                }
            }
            if (cacheSet.size() > maxLength) {
                maxLength = cacheSet.size();
            }
            cacheSet.clear();
        }

        return maxLength;

    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_window(String s) {
        HashSet<Character> cacheSet = new HashSet<Character>();
        int maxLength = 0;
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

}
