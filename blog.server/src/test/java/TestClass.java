import org.junit.Test;

/**
 * @author zhulinzhong
 * @date 2022-03-02 19:59:44
 */
public class TestClass {
    @Test
    public void test() {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, result = Integer.MAX_VALUE, sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                result = Math.min(result, right-left+1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
