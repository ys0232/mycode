package base;

import java.util.ArrayList;

class pos{
    int x,y;

    public pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BFS {
    public static void main(String[] args){
        int n=6;int m=6;
        char[][] a=new char[n][m];
        int k=0;int x0=4,y0=2;
        a[k++]="...#..".toCharArray();
        a[k++]="......".toCharArray();
        a[k++]="#*##..".toCharArray();
        a[k++]="..##.#".toCharArray();
        a[k++]="..X...".toCharArray();
        a[k]=".@#...".toCharArray();
        pos[] dir={new pos(-1,0),new pos(0,-1),new pos(1,0),new pos(0,1)};
        ArrayList<pos> que=new ArrayList<>();
        que.add(new pos(x0,y0));
        int[][] min=new int[n][m];
        int inf=100000;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                min[i][j]=inf;
            }
        }
        min[x0][y0]=0;int res=0;
        boolean flag=true;
        while (!que.isEmpty()){
            pos p0=que.get(0);que.remove(0);
            if (flag && a[p0.x][p0.y]=='@'){
                res=min[p0.x][p0.y];
                break;
            }
            if (a[p0.x][p0.y] == '*') {
                flag = true;
            }
            for (int i=0;i<dir.length;i++){
                int x=dir[i].x+p0.x;
                int y=dir[i].y+p0.y;
                if (x>=0&&x<n&&y>=0&&y<m&&
                        a[x][y]!='#'&&min[x][y]==inf){
                    que.add(new pos(x,y));
                    min[x][y]=min[p0.x][p0.y]+1;
                }
            }
        }
        System.out.println(res);
    }
}
