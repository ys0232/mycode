package AtOffer;

import java.util.Arrays;

/**
 * Created by yolin on 2018/3/4.
 */
public class Match {

    public static void main(String[] args) {
        char[] chars = "ah".toCharArray();
        char[] chars1 = "k*".toCharArray();
        System.out.println(match(chars, chars1));
        System.out.println(matchDP(chars, chars1));

    }

    private static boolean match(char[] str, char[] pattern) {
        System.out.println(Arrays.toString(str) + "\t" + String.valueOf(pattern));
        // use recursion
        return matchCore(str, 0, pattern, 0);

    }

    private static boolean IsMatch(char[] str, int start, char[] pattern, int index) {
        System.out.println(start + "\t" + index);
        if ((str.length - start) <= 0 && (pattern.length - index) <= 0)
            return true;
        if ((str.length - start) >= 0 && (pattern.length - index) <= 0)
            return false;
        if ((str.length - start) <= 0 && (pattern.length - index) >= 0) {
            if (index + 1 < pattern.length && pattern[index + 1] == '*') {
                return IsMatch(str, start, pattern, index + 2);
            }
            return false;
        }
        if (index + 1 < pattern.length && pattern[index + 1] == '*') {
            if (pattern[index] == str[start] || (start < str.length && pattern[index] == '.')) {
                return IsMatch(str, start, pattern, index + 2) ||
                        IsMatch(str, start + 1, pattern, index) ||
                        IsMatch(str, start + 1, pattern, index + 2);
            } else return IsMatch(str, start, pattern, index + 2);
        }

        if (pattern[index] == str[start] || (pattern[index] == '.' && start < str.length)) {
            return IsMatch(str, start + 1, pattern, index + 1);
        }
        return false;

    }


    public  static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
//str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
//str未到尾，pattern到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
//str到尾，pattern未到尾(不一定匹配失败，因为a*可以匹配0个字符)
        if (strIndex == str.length && patternIndex != pattern.length) {
//只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
            return false;
        }

//str未到尾，pattern未到尾
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//*匹配0个，跳过
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//*匹配1个，跳过
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {

                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;
    }

    private static boolean matchDP(char[] str,char[] pattern){
    // use dynamic programming
        boolean[][] dp=new boolean[str.length+1][pattern.length+1];
        dp[0][0]=true;
        for (int i=1;i<dp[0].length;i++){
            if (pattern[i-1]=='*')dp[0][i]=dp[0][i-2];
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                if (pattern[j-1]=='.' || pattern[j-1]==str[i-1])
                    dp[i][j]=dp[i-1][j-1];
                else if (pattern[j-1]=='*'){
                 if (pattern[j-2]!=str[i-1] && pattern[j-2]!='.')
                     dp[i][j]=dp[i][j-2];
                 else dp[i][j]=dp[i][j-1]||dp[i][j-2] || dp[i-1][j];
                }
            }
        }
        return dp[str.length][pattern.length];
    }

}
