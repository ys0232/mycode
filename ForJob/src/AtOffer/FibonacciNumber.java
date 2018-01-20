package AtOffer;

/**
 * Created by lenovo on 2018/1/14.
 */
public class FibonacciNumber {
    public static void main(String[] args){
        int n=37;
        System.out.println(Fibonacci(n));
    }
    private static int Fibonacci(int n){
        int f1=0,f2=1,f3;
        for (int i=0;i<n;i++){
        f3=f1+f2;
        f1=f2;
        f2=f3;
    }
        return f1;
    }
}
