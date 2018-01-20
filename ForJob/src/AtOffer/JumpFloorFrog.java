package AtOffer;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/1/14.
 *  fn = fn-1 + fn-2
 */
public class JumpFloorFrog {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(JumpFloor(n));
    }

    private static int JumpFloor(int target) {
        int f1 = 0, f2 = 1, f3;
       if (target == 0) return 0;
        for (int i = 0; i < target; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
