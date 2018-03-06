package AtOffer;

/**
 * Created by yolin on 2018/3/4.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNextNode {
    public static void main(String[] args) {

    }

    private static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            TreeLinkNode p=pNode.right;
            while (p.left!=null){
                p=p.left;
            }
            return p;
        }else {
            while (pNode.next!=null){
                TreeLinkNode p=pNode.next;
            if (p.left==pNode)return p;
            pNode=pNode.next;
        }
        }
        return null;
    }
}
