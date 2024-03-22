package test3;

//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
public class LinkedListDelete {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        int val = 6;
        ListNode l = removeElements(l1, val);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //添加虚拟头结点的方式
    //需要注意的是在是否删除结点时指针的移动是不同的
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);   //设置一个虚拟头结点,用来统一所有结点的删除方式
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;   //若是需要删除该结点,则cur不用移动,只用改变cur.next指向的结点
            } else {
                cur = cur.next;             //若是不需要删除结点,则cur需要向下一个结点移动
            }
        }
        return dummyNode.next;
    }
}
