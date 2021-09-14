package structure.link;

import org.junit.jupiter.api.Test;

public class MyLinkedList {

    int size;
    ListNode head; // 哨兵节点

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        ListNode node = head;
        for(int i=0;i<index+1;i++){
            node = node.next;
        }
        return node==null?-1:node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0 || size < index){
            throw new IndexOutOfBoundsException();
        }
        ++size;
        ListNode prev = head;
        for(int i = 0;i<index;i++){
            prev = prev.next;
        }
        ListNode node1 = new ListNode(val);
        node1.next = prev.next;
        prev.next = node1;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        --size;
        ListNode prev = head;
        for(int i = 0;i<index;i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    @Test
    public void testMyLinkedList(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(0);  //现在链表是2-> 3
        System.out.println(linkedList.get(0));
    }
}
