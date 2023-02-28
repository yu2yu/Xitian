package structure.link;

public class MergeSortrdNode {


    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode l3 = l1;
        ListNode l4 = l3;
        while(l1 != null && l2!= null){
            if(l1.val > l2.val){
                l3.next = l2;
                l2 = l2.next;
            }else{
                l3.next = l1;
                l1 = l1.next;
            }
            l3 = l3.next;
        }
        l3.next = l1 == null?l2:l1;
        return l4.next;
    }


    // 合并K个有序链表
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

}
