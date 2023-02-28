package leetcode;

import java.util.*;

/**
 * 给你两个二维整数数组items1 和items2，表示两个物品集合。每个数组items有以下特质：
 *
 * items[i] = [valuei, weighti] 其中valuei表示第i件物品的价值，weighti表示第 i件物品的 重量。
 * items中每件物品的价值都是 唯一的。
 * 请你返回一个二维数组ret，其中ret[i] = [valuei, weighti]，weighti是所有价值为valuei物品的重量之和。
 *
 */
public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] ints : items1) {
            map.put(ints[0],map.getOrDefault(ints[0],0) + ints[1]);
        }

        for (int[] ints : items2) {
            map.put(ints[0],map.getOrDefault(ints[0],0) + ints[1]);
        }

        List<Integer> integers = new ArrayList<>(map.keySet());

        Collections.sort(integers);

        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (Integer integer : integers) {
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(integer);
            objects.add(map.get(integer));
            lists.add(objects);
        }

        return lists;

    }

}
