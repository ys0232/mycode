package AtOffer;

/**
 * Created by yolin on 2018/1/14.
 * consider the negative exponent
 */
public class PowerOfFloat {

    public static void main(String[] args) {
        double base = 2;
        int exponent = -3;
        System.out.println(Power(base, exponent));
    }

    private static double Power(double base, int exponent) {
        double result = 1;
        int flag = 1;
        if (exponent < 0) {
            flag = -1;
            exponent = -exponent;
        }
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }
        if (flag == -1) {
            result = 1.0 / result;
        }
        return result;
    }
}
