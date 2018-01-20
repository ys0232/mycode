package AtOffer;

/**
 * Created by yolin on 2018/1/16.
 */
public class StrToInt {
    public static void main(String[] args) {
        String str1 = "-123213", str2 = "0090sads+";
        System.out.println(StrToInt(str1) + "\t" + StrToInt(str2));

    }

    private static int StrToInt(String str) {
        if (str.length()==0)return 0;
        int result = 0;
        char k = str.charAt(0);
        if (k != '+' && k != '-' && (k < '0' || k > '9')) return result;
        for (int i = 1; i < str.length(); i++) {
            k = str.charAt(i);
           // System.out.print(k+"\t");
            if (k < '0' || k > '9') return result;
        }
       // System.out.println();
        int len = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            k = str.charAt(i);
            //System.out.println(k+"\t"+result);
            if (k == '+' || k == '-') {
                len = len - 1;
                continue;
            }
            result = result * 10 + k - '0';
        }
        if (str.charAt(0) == '-') result = -result;
        return result;
    }
}
