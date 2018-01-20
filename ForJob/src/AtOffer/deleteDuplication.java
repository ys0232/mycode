package AtOffer;

import jdk.nashorn.internal.runtime.ListAdapter;

/**
 * Created by yolin on 2018/1/20.
 */
public class deleteDuplication {
    public static void main(String[] args){
        int[] a={1,1,2,2,5,5,9,9,10,10,12};
        ListNode head=new ListNode(a[0]);
        ListNode p=head;
        for(int i=1;i<a.length;i++){
            p.next=new ListNode(a[i]);
            p=p.next;
        }
        //p=head;
       p=deleteDuplicationNode(head);
        while (p!=null){
            System.out.print(p.val+"####\t");
            p=p.next;
        }

    }
    private static ListNode deleteDuplicationNode(ListNode pHead){
        if (pHead==null || pHead.next==null)return pHead;
        ListNode p=pHead,pre;
        int val=pHead.val;
        while ( p!=null && p.next!=null && p.next.val==val){
            p.next=p.next.next;
            p=p.next;
            if (p!=null)
            val=p.val;
        }
        if (p==null || p.val==val)return null;
        pHead=p;pre=p.next;
        if (pre==null)return pHead;
       System.out.println(pHead.val);
       val=p.val;
        while (pre!=null){
            if (pre.val==val){
                p.next=pre.next.next.next;
                pre=p.next;
            }else {
                val=pre.val;
                p=p.next;
                pre=pre.next;
            }
        }

        return pHead;
    }
}
