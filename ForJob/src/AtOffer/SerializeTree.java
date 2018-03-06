package AtOffer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yolin on 2018/3/6.
 */
public class SerializeTree {

    private static String Serialize(TreeNode root){

        String str="";
        if (root==null)return "#\t";
      str=root.val+"\t";
      str+=Serialize(root.left);
      str+=Serialize(root.right);
        return str;
    }
    private TreeNode Deserialize(String str){
        String[] values=str.split("\t");
        Queue<String> queue=new LinkedList<>();
        for (int i=0;i!=values.length;i++){
            queue.offer(values[i]);
        }
        return preOrder(queue);
    }
    private static TreeNode preOrder(Queue<String> queue){
        if (queue.isEmpty())return null;
        String value=queue.poll();
        if (value.equals("#"))return null;
        TreeNode head=new TreeNode(Integer.valueOf(value));
        head.left=preOrder(queue);
        head.right=preOrder(queue);
        return head;
    }
    public static void main(String [] args){
        int[] pre={8,6,10,5,7,9,11};
        TreeNode root=new TreeNode(pre[0]);
        TreeNode p,q;
        p=root;q=root;
        int flag=-1;
        for (int i=1;i<pre.length;i+=2){
            p.left=new TreeNode(pre[i]);
            if (i<pre.length-1)
                p.right=new TreeNode(pre[i+1]);
            if (flag==-1){
                flag=1;
                q=p;
                p=p.left;
            }else {
                flag=-1;
                p=q.right;
            }
        }
        String string=Serialize(root);
        System.out.println(string);

    }
}
