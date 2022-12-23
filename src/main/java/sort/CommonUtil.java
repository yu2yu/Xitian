package sort;

public class CommonUtil {

    public static int[] generateArray(int len,int max){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    /**
     * 交换
     * @param i
     * @param j
     * @param nums
     */
    public static void swap(int i,int j,int[] nums){
        if(i != j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
