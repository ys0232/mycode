package AtOffer;

/**
 * Created by lenovo on 2018/1/14.
 *  fn = 0 (n <= 0);
 *  fn = 1 (n == 1)
 *  fn = fn-1 + fn-2 + ... + f0 = fn-1 + fn-1 = 2 * fn-1
 */
public class EnhanceJumpFloorFrog {

    public static void main(String[] args){
        int n=3;
        System.out.println(JumpFloorII(n));
    }
    private static int JumpFloorII(int target) {
        if (target == 0)return 0;
        int f2=1,f3;
        for (int i=1;i<target;i++){
            f3=2*f2;
            f2=f3;
        }
        return f2;
    }
}
