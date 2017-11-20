/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-16
 * Time: 下午6:44
 */
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class Leetcode_13_2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode l1=new ListNode(9);
        ListNode node1=new ListNode(9);
        ListNode node2=new ListNode(9);
        
        ListNode l2=new ListNode(1);
        ListNode node3=new ListNode(6);
        ListNode node4=new ListNode(4);
        l1.next=node1;
        node1.next=node2;
//        l2.next=node3;
//        node3.next=node4;
        ListNode l3=solution.addTwoNumbers(l1,l2);
        System.out.print("l1 = ");
        while (l1!=null){
            System.out.print(l1.val+",");
            l1=l1.next;
        }
        System.out.println("");
        System.out.print("l2 = ");
        while (l2!=null){
            System.out.print(l2.val+",");
            l2=l2.next;
        }
        System.out.println("");
        System.out.print("l3 = ");
        while (l3!=null){
            System.out.print(l3.val+",");
            l3=l3.next;
        }
        System.out.println("");
    }
}
