package AtOffer;

import java.util.Arrays;

/**
 * Created by yolin on 2018/3/4.
 */
public class IsNumeric {
   static char[] arr="+-n.ne+-n".toCharArray();
    static  int[][] turn={
            //+  -  n  .  n  e  +  -  n
            {1, 1, 1, 0, 0, 0, 0, 0, 0},    // # start
            {0, 0, 1, 1, 0, 0, 0, 0, 0},    // +
            {0, 0, 1, 1, 0, 0, 0, 0, 0},    // -
            {0, 0, 1, 1, 0, 1, 0, 0, 0},    // n
            {0, 0, 0, 0, 1, 0, 0, 0, 0},    // .
            {0, 0, 0, 0, 1, 1, 0, 0, 0},    // n
            {0, 0, 0, 0, 0, 0, 1, 1, 1},    // e
            {0, 0, 0, 0, 0, 0, 0, 0, 1},    // +
            {0, 0, 0, 0, 0, 0, 0, 0, 1},    // -
            {0, 0, 0, 0, 0, 0, 0, 0, 1}     // n
    };
    public static void main(String[] args) {
        String[] str = {"+1213", "-1e-232", "-e123", "+.e1231","788e"};
        for (String s : str) {
            //System.out.println(isNumeric(s.toCharArray()));
            System.out.println(solution(s.toCharArray()));
        }
    }

    private static boolean isNumeric(char[] str) {
        if (str.length <= 0) return false;

        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
    private static boolean solution(char[] str){

        int cur=0;
        for (int i=0,j;i<str.length;i++){
            for (j=0;j<9;j++){
                if (turn[cur][j]==1){
                   // System.out.println(Arrays.toString(str)+"\t"+cur+"\t"+str[i]+"\t"+arr[j]);
                    if ('0'<=str[i] && str[i]<= '9'&& arr[j]=='n'||
                            (str[i]=='E' && arr[j]=='e') || str[i]==arr[j]){
                        cur=j+1;
                        break;
                    }

                }

            }
            if (j==9)return false;
            //if (j==9)break;
        }
        if (cur==3 || cur==4 || cur==5 || cur==9)return true;
        return false;

    }

}
