package AtOffer;


import java.util.ArrayList;

/**
 * Created by yolin on 2018/1/20.
 */
public class deleteDuplication {
    public static void main(String[] args){
        int[] a={1,1,1,1,1,3,3,4};
        ListNode head=new ListNode(a[0]);
        ListNode p=head;
        for(int i=1;i<a.length;i++){
            p.next=new ListNode(a[i]);
            p=p.next;
        }
        p=head;
        while (p!=null){
            System.out.print(p.val+"\t");
            p=p.next;
        }
       p=deleteDuplicationNode(head);
        while (p!=null){
            System.out.print(p.val+"####\t");
            p=p.next;
        }

    }
    private static ListNode deleteDuplicationNode(ListNode pHead){
        if (pHead==null || pHead.next==null)return pHead;
        ListNode vp=new ListNode(888);
        vp.next=pHead;
        ListNode p=pHead,last=vp;
        while (p!=null && p.next!=null){
            if (p.val==p.next.val){
                int val=p.val;
                while (p!=null && p.val == val){
                    p=p.next;
                    last.next=p;
                }
            }else {
                last=p;
                p=p.next;
            }
        }
        return vp.next;
    }
}
