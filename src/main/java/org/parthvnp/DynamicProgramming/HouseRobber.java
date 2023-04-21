package org.parthvnp.DynamicProgramming;

public class HouseRobber {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		if (nums.length == 1) return nums[0];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
		return dp[nums.length - 1];
	}

  public static void main(String[] args) {
	  var s = new HouseRobber();
	  var e1 = s.rob(new int[] {1, 2, 3, 1});
	  System.out.println(e1 == 4);
  }
}
