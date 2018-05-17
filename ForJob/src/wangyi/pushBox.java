package wangyi;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Scanner;
class pos{
    int x,y;
int len=0;
    public pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class pushBox {
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            char[][] a=new char[n][m];
            int x0=0,y0=0;boolean flag=true;
            for (int i=0;i<n;i++){
                String s=sc.next();
                a[i]=s.toCharArray();
                if (flag){
                for (int j=0;j<a[i].length;j++){
                    if (a[i][j]=='X'){
                        x0=i;y0=j;
                        flag=false;break;
                    }
                }
                }
            }
            min= Integer.MAX_VALUE;
            int[][] visited=new int[n][m];
            dfs(a,x0,y0,false,1,visited);
            System.out.println(" min=\t"+min);

        }
    }
    private static void bfs(int n,int m,int x0,int y0,int[][] a,boolean flag){
        int[][] visited=new int[n][m];
        LinkedList<pos> que=new LinkedList<>();
        que.add(new pos(x0,y0));
        int min=Integer.MAX_VALUE;
        pos[] dir={new pos(0,-1),new pos(-1,0),new pos(0,1),new pos(1,0)};
        while (!que.isEmpty()){
            pos p=que.poll();
            visited[p.x][p.y]=1;
            System.out.println(p.x+"\t"+p.y+"\t"+que.size());
            if (flag&&a[p.x][p.y]=='@'){
                if (min>p.len-1){
                    min=p.len-1;
                    System.out.println("########!!!!"+min);
                    flag=false;
                }
            }
            if (a[p.x][p.y]=='*'){
                flag=true;min=min<p.len?min:p.len;
                System.out.println("find box "+min);
                //visited=new int[n][m];
            }
            for (pos p0:dir){
                int x = p.x + p0.x;
                int y = p.y + p0.y;
                if (x >= 0 && x < n && y >= 0 && y < m &&
                        visited[x][y]==0&&(a[x][y] != '#')) {
                    pos temp=new pos(x,y);
                    temp.len=p.len+1;
                    que.add(temp);
                }
            }
        }
    }
    private static void dfs(char[][] a,int x0,int y0,boolean flag,int len,int[][] visited){
        int n=a.length;int m=a[0].length;
        if (flag&&a[x0][y0]=='@'){
            min=min<len?min:len;
            return;
        }
        if (a[x0][y0]=='*'){
            flag=true;
        }else visited[x0][y0]=1;
        System.out.println(x0+"\t"+y0+"\t"+len+"\t"+flag);
        int[][] dir={{0,-1},{-1,0},{0,1},{1,0}};
        for (int i=0;i<dir.length;i++){
            int x=x0+dir[i][0];
            int y=y0+dir[i][1];
            if (x >= 0 && x < n && y >= 0 && y < m && (a[x][y] != '#')&&visited[x][y]==0){
                dfs(a,x,y,flag,len+1,visited);
            }
        }

    }


}
