package LC20240724;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MergeInterval {


    public int[][] merge(int[][] intervals) {
        // 首先排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            // 结果集为空或者结果集最后一个的右边小于L 那么直接添加
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L, R});
            }
            else {
                int max = Math.max(merged.get(merged.size() - 1)[1], R);
                merged.get(merged.size() - 1)[1] = max;
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    @Test
    @DisplayName("合并区间")
    public void testThreeSum(){
        assertAll(
                () -> assertArrayEquals(new int[][]{{1,6},{8,10},{15,18}}, merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})),
                () -> assertArrayEquals(new int[][]{{1, 5}}, merge(new int[][]{{1,4},{4,5}}))
        );
    }

}
