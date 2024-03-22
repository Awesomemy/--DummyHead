package test3;

/**
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 *
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 *
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 *
 * 实现 MyLinkedList 类：
 *
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 */
public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);     //设置虚拟头结点
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        if (index<0 || index>size-1) {    //下标越界返回-1
            return -1;
        }
        ListNode currentNode=head;
        //由于包含一个虚拟头结点,所以实际上是要查找第index+1个结点
        for(int i=0;i<=index;i++){
            currentNode=currentNode.next;     //只用考虑找第0个结点的情况来判断对不对
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index>size) {
            return;
        }
        if (index<0) {
            index=0;
        }
        size++;  //插入结点记得更新链表长度
        ListNode preNode=head;   //找到要插入结点的前驱
        for(int i=0;i<index;i++){
            preNode=preNode.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next=preNode.next;
        preNode.next=newNode;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>=size){
            return;
        }
        size--;
        ListNode preNode=head;//也是先找到要删除结点的前驱
        for(int i=0;i<index;i++){
            preNode=preNode.next;
        }
        preNode.next = preNode.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
}
