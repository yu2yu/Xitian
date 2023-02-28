package structure.array;

public class MaxSubArray {


    public int maxSubArray(int[] nums){
        int sum = nums[0];
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i],nums[i]);
            sum = Math.max(sum,pre);
        }
        return sum;
    }
}
