package random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @desc 给你一个整数数组salary，数组里每个数都是 唯一的，其中salary[i] 是第i个员工的工资。
 *
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 */
public class AverageSalary {

    /**
     * 如何快速查出最大值和最小值
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        if(salary == null){
            return 0;
        }
        int max = salary[0],min = salary[0];
        int sum = 0;
        for (int i : salary) {
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
            sum += i;
        }
        sum = sum - max - min;
        return (double)sum / (salary.length - 2);
    }

    @Test
    public void testCanIWin(){
        assertEquals(3500.00000D,average(new int[]{6000,5000,4000,3000,2000,1000}));
        assertEquals(4750.00000D,average(new int[]{8000,9000,2000,3000,6000,1000}));
        assertEquals(2000.00000,average(new int[]{1000,2000,3000}));
    }
}
