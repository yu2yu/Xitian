package structure.string;

public class LengthOfLTS {


    public int lengthOfLTS(int[] nums){
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int max = 1;
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) prev++;
            else prev = 1;
            max = Math.max(max,prev);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLTS().lengthOfLTS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
