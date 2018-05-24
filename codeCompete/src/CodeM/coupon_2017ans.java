package CodeM;

import java.util.ArrayList;
import java.util.Scanner;

public class coupon_2017ans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxN = 100005;
        int m = sc.nextInt();
        int res = -1;
        ArrayList<Integer> mark = new ArrayList<>();
        int[] cnt = new int[maxN];
        int[] la = new int[maxN];
        for (int i = 1; i <= m; i++) {
            String op = sc.next();
            if (op.equals("?")) {
                mark.add(i);
                continue;
            }
            int x = sc.nextInt();
            cnt[x] += (op.equals("I") ? 1 : -1);
            if (cnt[x] < 0 || cnt[x] > 1) {
                int t = find(la[x], mark);
                if (t == -1) {
                    res = i;
                    break;
                }
                mark.remove(t);
                cnt[x] = cnt[x] < 0 ? 0 : 1;
                //cnt[x]=Math.min(Math.max(cnt[x],0),1);
            }
            la[x] = i;
        }
        System.out.println(res);
    }

    private static int find(int la, ArrayList<Integer> mark) {
        if (mark.size() == 0) return -1;
        int low = 0, high = mark.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int t = mark.get(mid);
            if (t <= la) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        //int res=low==mark.size()?-1:low;
        int res;
        if (mark.get(low) > la) {
            res = low;
        } else res = -1;
        return res;
    }
}
