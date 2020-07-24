package coding.leetcode.string;

/**
 * 类型：动态规划！！！
 * @link https://leetcode-cn.com/problems/interleaving-string/
 * @desc
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 *
 * 示例 2:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 *
 */
public class Interleave {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
//        return recIsInterleave(s1,s2,s3, s1.length()-1, s2.length()-1,s3.length()-1);
        return dpIsInterleave(s1,s2,s3);
    }

    private static boolean recIsInterleave(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index) {
        if (s1Index == -1) {
            String s2Sub = s2.substring(0, (s2Index+1));
            String s3Sub = s3.substring(0, (s3Index+1));
            return s2Sub.equals(s3Sub);
        }
        if (s2Index == -1) {
            String s1Sub = s1.substring(0, (s1Index+1));
            String s3Sub = s3.substring(0, (s3Index+1));
            return s1Sub.equals(s3Sub);
        }
        char s1Char = s1.charAt(s1Index);
        char s2Char = s2.charAt(s2Index);
        char s3Char = s3.charAt(s3Index);
        if (s1Char != s3Char && s2Char!=s3Char) {
            return false;
        }else if (s1Char == s3Char && s2Char!=s3Char) {
            return recIsInterleave(s1,s2,s3, s1Index-1, s2Index,s3Index-1);
        }else if (s1Char != s3Char && s2Char ==s3Char) {
            return recIsInterleave(s1,s2,s3, s1Index, s2Index-1,s3Index-1);
        }else{
            // (s1Char == s3Char && s2Char ==s3Char)
            return recIsInterleave(s1,s2,s3, s1Index, s2Index-1,s3Index-1) ||
                    recIsInterleave(s1,s2,s3, s1Index-1, s2Index,s3Index-1);
        }
    }


    private static boolean dpIsInterleave(String s1, String s2, String s3) {
        boolean[][] dpArray = new boolean[s1.length()+1][s2.length()+1];
        dpArray[0][0] = true;

        for (int i =0; i<=s1.length(); i++){
            for (int j =0; j<=s2.length(); j++){
                if (i>0) {
                    dpArray[i][j] =  dpArray[i][j]||(dpArray[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
                if (j>0) {
                    dpArray[i][j] =  dpArray[i][j]||(dpArray[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dpArray[s1.length()][s2.length()];

    }


    public static void main(String[] args) {
        String s1="aabcc", s2="dbbca", s3="aadbbcbcac";
        System.out.println(isInterleave(s1,s2,s3));
    }

}
