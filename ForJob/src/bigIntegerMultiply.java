import java.util.Arrays;

/**
 * Created by lenovo on 2017/12/25.
 */
public class bigIntegerMultiply {
    private static String bit2bit(String a, String b) {
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        int len1 = num1.length;
        int len2 = num2.length;
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                result[len1 + len2 - i - j - 2] += (num1[i] - '0') * (num2[j] - '0');
            }
        }
        String ans = "";
        for (int i = 0, c = 0; i < len1 + len2; i++) {
            result[i] += c;
            c = result[i] / 10;
            result[i] = result[i] % 10;
            ans = String.valueOf(result[i]) + ans;
        }
        ans = ans.replaceFirst("^0*", "");
        return ans;
    }

    private static String moveBit(String a, String b) {
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        int len1 = num1.length;
        int len2 = num2.length;
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1, k = 0; i >= 0; i--, k++) {
            int carry = 0;
            int k_j = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                carry+=result[k+k_j];
                result[k + k_j] = (num1[i] - '0') * (num2[j] - '0') + carry;
                carry = result[k + k_j] / 10;
                result[k + k_j] = result[k + k_j] % 10;
                k_j++;
            }
            while (carry != 0) {
                result[k + k_j] = carry % 10;
                carry /= 10;
                k_j++;
            }
        }
        String ans = "";
        for (int i = 0; i < result.length; i++) {
            ans = String.valueOf(result[i]) + ans;
        }
        ans = ans.replaceFirst("^0*", "");
        return ans;
    }

    private static String Divide_Conquer(String a, String b) {
        if (a.length() <= 6 && b.length() <= 6) {
            long result = Long.valueOf(a) * Long.valueOf(b);
            return String.valueOf(result);
        } else {
            int len = a.length() < b.length() ? a.length() : b.length();
            int lena = a.length();
            int lenb = b.length();
            String a1 = a.substring(0, lena - len / 2 - 1);
            String a2 = a.substring(lena - len / 2 - 1);
            String b1 = b.substring(0, lenb - len / 2 - 1);
            String b2 = b.substring(lenb - len / 2 - 1);
            String ans1 = Divide_Conquer(a1, b1);
            String ans2 = Divide_Conquer(a2, b2);
            String ans3 = Divide_Conquer(BigAdd(a1, a2), BigAdd(b1, b2));
            String ans4 = BigSub(BigSub(ans3, ans1), ans2);
            int k = 0;
            while (k < 2 * (len / 2 + 1)) {
                ans1 = ans1 + "0";
                if (k < len / 2 + 1) {
                    ans4 = ans4 + "0";
                }
                k++;
            }
            ans1 = BigAdd(ans1, ans4);
            return BigAdd(ans1, ans2);
        }
    }

    private static String BigAdd(String a, String b) {
        //Nonnegative addition.
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        String result = "";
        int len = num1.length > num2.length ? num1.length : num2.length;
        int carry = 0;
        boolean flag1 = true;
        boolean flag2 = true;
        int len1 = num1.length;
        int len2 = num2.length;
        for (int i = 0; i < len; i++) {
            int tmp ;
            if (len1 - 1 - i < 0) {
                flag1 = false;
            }
            if (len2 - 1 - i < 0) {
                flag2 = false;
            }
            if (flag1 && flag2) {
                tmp = num1[len1 - 1 - i] - '0' + num2[len2 - 1 - i] - '0' + carry;
            } else if (!flag1) {
                tmp = num2[len2 - 1 - i] - '0' + carry;
            } else {
                tmp = num1[len1 - 1 - i] - '0' + carry;
            }
            carry = tmp / 10;
            tmp %= 10;
            result = String.valueOf(tmp) + result;
        }
        if (carry != 0) {
            result = String.valueOf(carry) + result;
        }
        return result;
    }

    private static String BigSub(String a, String b) {
        //Nonnegative subtraction,the subtrahend is a,the minuend is b.
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        int len = a.length() < b.length() ? a.length() : b.length();
        int sub = 0;
        String result = "";
        for (int i = 0; i < len; i++) {
            int t1 = num1[num1.length - 1 - i] - '0' - sub;
            int t2 = num2[num2.length - 1 - i] - '0';
            if (t1 < t2) {
                sub = 1;
                t1 = t1 + 10;
            } else {
                sub = 0;
            }
            result = String.valueOf(t1 - t2) + result;
        }
        int k = num1.length - len - 1;
        while (k >= 0) {
            int t = num1[k] - '0' - sub;
            // System.out.println(t);
            if (t < 0) {
                sub = 1;
                t = t + 10;
            } else {
                sub = 0;
            }
            result = String.valueOf(t) + result;
            //  System.out.println(result);
            k--;
        }
        result = result.replaceFirst("^0*", "");
        return result;
    }

    public static void main(String[] args) {
        String a = "2513432";
        String b = "23212043";
        String c = "102146035384364";
        System.out.println(bit2bit(a, b));
        System.out.println(moveBit(a, b));
        System.out.println(Divide_Conquer(a, b));
        // System.out.println(BigAdd(a, b));
        //  System.out.println(BigSub(c, a));

    }
}
