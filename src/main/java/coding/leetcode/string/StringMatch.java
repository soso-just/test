package coding.leetcode.string;

/**
 * @link https://leetcode-cn.com/problems/wildcard-matching/
 * @desc 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 */
public class StringMatch {
    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] trueCache = new boolean[sLen+1][pLen+1];
        boolean[][] falseCache = new boolean[sLen+1][pLen+1];
        return isMatch(s, p, sLen-1, pLen-1, trueCache,falseCache);
    }

    private static boolean isMatch(String str, String matchStr, int strIndex, int matchStrIndex, boolean[][] trueCache, boolean[][] falseCache) {
        if (trueCache[strIndex+1][matchStrIndex+1] ==true) {
            return true;
        }
        if (falseCache[strIndex+1][matchStrIndex+1] ==true) {
            return false;
        }
        if (strIndex< 0 && matchStrIndex<0) {
            trueCache[strIndex+1][matchStrIndex+1] =true;
            return true;
        }
        if (strIndex>= 0 && matchStrIndex<0) {
            falseCache[strIndex+1][matchStrIndex+1] =true;
            return false;
        }
        if (strIndex< 0 && matchStrIndex>=0) {
            for (int i=0; i<=matchStrIndex; i++ ){
                if (matchStr.charAt(i) !='*') {
                    falseCache[strIndex+1][matchStrIndex+1] =true;
                    return false;
                }
            }
            trueCache[strIndex+1][matchStrIndex+1] =true;
            return true;
        }
        //strIndex>0 并且matchStrIndex>0
        char matchChar = matchStr.charAt(matchStrIndex);
        if (matchChar == '*') {
            return (isMatch(str, matchStr, strIndex-1, matchStrIndex, trueCache,falseCache))
                    ||(isMatch(str, matchStr, strIndex, matchStrIndex-1, trueCache,falseCache));
        }
        if (matchChar == '?'){
            return isMatch(str, matchStr, strIndex-1, matchStrIndex-1, trueCache,falseCache);
        }
        if (matchChar == str.charAt(strIndex)) {
            return isMatch(str, matchStr, strIndex-1, matchStrIndex-1, trueCache,falseCache);
        }
        falseCache[strIndex+1][matchStrIndex+1] =true;
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi","m??*ss*?i*pi"));
        System.out.println(isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab","*aabb***aa**a******aa*"));
    }
}
