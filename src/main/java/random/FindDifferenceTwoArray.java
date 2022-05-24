package random;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，
 * 请你返回一个长度为 2 的列表 answer ，其中：
 *
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 *
 */
public class FindDifferenceTwoArray {


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> result = new ArrayList<>();
        //list1和list2存储不同于对方的整数
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Set<Integer> l1 = new HashSet<>();
        Set<Integer> l2 = new HashSet<>();

        for (int i : nums1) {
            l1.add(i);
        }

        for (int i : nums2) {
            l2.add(i);
        }
        //直接暴力求解
        for (int i = 0; i < nums1.length; i++) {
            if(!l2.contains(nums1[i]) && !list1.contains(nums1[i])){
                list1.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(!l1.contains(nums2[i]) && !list2.contains(nums2[i])){
                list2.add(nums2[i]);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;

    }


    @Test
    public void testFindDifference(){
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }
}
