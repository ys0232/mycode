package wangyi;

import java.util.*;

class position {
    int x, y;
    position pre=null;
    boolean visit=false;


    public position getPre() {
        return pre;
    }

    public void setPre(position pre) {
        this.pre = pre;
    }

    public position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class DungeonEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
           // System.out.println(n+"\t"+m);
            char[][] a = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s=sc.next();
                a[i]=s.toCharArray();
            }
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            position p0 = new position(x0, y0);
            int k = sc.nextInt();
            position[] dir = new position[k];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                dir[i] = new position(x, y);
            }
            LinkedList<position> que = new LinkedList<>();
            que.add(p0);
            int max = 0;
            int tp_max = 0;
            position last = p0;
            while (!que.isEmpty()&&tp_max<=1) {
                position temp = que.poll();
                temp.visit=true;
                //que.remove(temp);
                if (temp.pre == null || last != temp.pre) {
                    tp_max += 1;
                    last=temp.pre;
                }
                System.out.println(que.size()+"\t"+temp.x+"\t"+temp.y);
                max=max>tp_max?max:tp_max;
                for (position p : dir) {
                    int x = temp.x + p.x;
                    int y = temp.y + p.y;
                    position q = new position(x, y);
                    if (!q.visit&&x>=0&& x<n && y>=0 &&y<m &&a[x][y]=='.') {
                        q.setPre(temp);
                        que.add(temp);
                    }
                }

            }
            System.out.println(max);
        }
    }

}
