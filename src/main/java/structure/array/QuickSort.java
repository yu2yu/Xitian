package structure.array;

import structure.link.ListNode;

import java.util.Random;

public class QuickSort {

    public ListNode mergeTwoLists(ListNode list1,ListNode list2){

        // 两个有序数组
        ListNode list3 = list1;
        ListNode mergeList = list3;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                list3.next = list1;
                list1 = list1.next;
            }else{
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }

        list3.next = list1 != null ? list1 : list2;
        return mergeList.next;
    }

}
