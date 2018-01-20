package AtOffer;

/**
 * Created by lenovo on 2018/1/14.
 *  Fibonacci Arrays
 */
public class RectangleCover {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(RectCover(n));
    }

    private static int RectCover(int target) {
        if (target == 0) return 0;
        int f1 = 1, f2 = 2, f3;
        for (int i = 1; i < target; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f1;
    }
}
