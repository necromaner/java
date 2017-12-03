/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-26
 * Time: 下午7:49
 */
/*
 Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Leetcode_23_24_SwapNodesinPairs {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
        ListNode node5=new ListNode(6);
        ListNode node6=new ListNode(7);
        ListNode node7=new ListNode(8);
        ListNode node8=new ListNode(9);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
//        node6.next=node7;
        node7.next=node8;
        ListNode swapPairs=solution.swapPairs(head);
        System.out.print(" head  is  = ");
        while (head!=null){
            System.out.print(head.val);
            if (head.next!=null){
                System.out.print("->");
            }
            head=head.next;
        }
        System.out.println("");
        
        System.out.print("swapPairs  = ");
        while (swapPairs!=null){
            System.out.print(swapPairs.val);
            if (swapPairs.next!=null){
                System.out.print("->");
            }
            swapPairs=swapPairs.next;
        }
        System.out.println("");
    }
}
