package AtOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lenovo on 2018/1/13.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class printLinkList {
    public static void main(String[] args) {
    int n=28;
        ListNode root=new ListNode(0);
        ListNode p=root;
    for (int i=1;i<n;i+=3){
        ListNode q=new ListNode(i);
        p.next=q;
        p=p.next;
    }
    p=root;
    while (p!=null){
        System.out.print(p.val);
        if (p.next!=null){
            System.out.print(" -> ");
        }
        p=p.next;
    }
        ArrayList<Integer> r=printListFromTailToHead(root);
        ArrayList<Integer> r1=printListFromTailToHead(p);
        System.out.println();
        System.out.println(Arrays.toString(r1.toArray()));
       // System.out.print();

    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result=new ArrayList<>();
        if (listNode==null){
            return result;
        }
        ListNode tail=listNode;
        ListNode p=tail.next;
         while (p!=null){
            listNode.next=listNode.next.next;
            p.next=tail;
            tail=p;
            p=listNode.next;
        }
        p=tail;
       while (p!=null){
            result.add(p.val);
            p=p.next;
        }
        return result;
    }
}
