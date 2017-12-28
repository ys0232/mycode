package ThirdDaysTest;

public class test {


test(int n, int k, int[] a){
    System.out.println(n + " " + k);
    for(int i = 0; i < n; i++){
        System.out.print(a[i] + " ");
    }
    System.out.println();
}

public static void main(String[] args) {
    // number of test cases - each test case is two lines
    int testCases = 5; 
    
    System.out.println(testCases);
    new test(4, 3, new int[] {-1, 0, 4, 2});
    new test(5, 2, new int[] {0, -1, 2, 1, 4});
    new test(7, 6, new int[] {2, 0, -1, 1 , 1 , 1, 1});
    new test(3, 1, new int[] {-1, 0, 4});
    new test(6, 4, new int[] {0, -1, 1, 4, 5, 6});
}
}