/**
 * @author youyu.song
 * @date 2019/6/22
 */
public class Solution {

	/**
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	 *
	 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
	 * 输出: 6
	 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	 *
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int second = nums[0];

		for (int i = 1; i < nums.length; i ++) {
			second = Math.max(nums[i], second + nums[i]);
			max = Math.max(max, second);
		}

		return max;

		//int max = nums[0];
		//int sum = nums[0];
		//for (int i = 1; i < nums.length; i ++) {
		//	if (sum > 0) {
		//		sum += nums[i];
		//	} else {
		//		sum = nums[i];
		//	}
		//
		//	max = sum > max ? sum : max;
		//}
		//
		//return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int array = solution.maxSubArray(nums);
		System.out.println(array);
	}




}
