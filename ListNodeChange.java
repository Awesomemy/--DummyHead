package test3;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
public class ListNodeChange {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode(0);  //设置虚拟头结点
        dummyhead.next = head;
        ListNode cur = dummyhead;  //用来遍历的结点
        //这里终止条件分奇偶讨论,并且利用短路特性避免了空指针异常
        ListNode temp1,temp2;  //设置两个临时结点用来保存交换中的结点
        while (cur.next != null && cur.next.next != null) {
            temp1 = cur.next;
            temp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;
            cur = cur.next.next;
        }
        return dummyhead.next;
    }
}

