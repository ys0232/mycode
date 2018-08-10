package CodeM.roundA;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class point{
    int x,y,res;

    public point(int x, int y,int res) {
        this.x = x;
        this.y = y;
        this.res=res;
    }
}

public class A {
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static String[][] b = {{"", "ABC", "DEF"}, {"GHI", "JKL", "MNO"},
            {"PQRS", "TUV", "WXYZ"}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String name = sc.next();
            char[] movie = name.toCharArray();
            point po=new point(0,0,0);
            for (int i = 0; i < movie.length;i++ ) {
                po=bfs(movie[i], po);
               // System.out.println(movie[i]+"\t"+po.res);

            }
            System.out.println(po.res);

        }
    }

    private static point bfs(char target, point p) {
        ArrayList<point> queue=new ArrayList<>();
        int[][] vis=new int[3][3];
        queue.add(p);vis[p.x][p.y]=1;
        point p0=p;
        while (!queue.isEmpty()){
            p0=queue.get(0);
            queue.remove(p0);
           int cur_x=p0.x,cur_y=p0.y;
            if (b[cur_x][cur_y].contains(String.valueOf(target))){
//                for (int i_p=0;i_p<b[cur_x][cur_y].length();i_p++){
//                    if (b[cur_x][cur_y].charAt(i_p)==target){
//                        p0.res+=i_p;break;
//                    }
//                }
                return p0;
            }
           // System.out.println(cur_x+"\t"+cur_y+"\t"+target+"\t"+b[cur_x][cur_y]+"\t"+p0.res);
            for (int i = 0; i < dir.length; i++) {
                int x = cur_x + dir[i][0];
                int y = cur_y + dir[i][1];
                if (x >= 0 && x < 3 && y >= 0 && y < 3 && vis[x][y]==0) {
                    vis[x][y]=1;
                    queue.add(new point(x,y,p0.res+1));
                }
            }

        }
        return p0;
    }
}
