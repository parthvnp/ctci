from typing import *
from shared.test import test


class HouseRobber:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2,n): dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        return dp[n - 1]

    def rob_top_down(self, nums: List[int]) -> int:
        n  = len(nums)
        memo = {}
        def dp(i):
            if i == 0 : return nums[0]
            if i == 1: return max(nums[0], nums[1])
            if i not in memo: memo[i] = max(dp(i-1), dp(i-2) + nums[i])
            return memo[i]
        return dp(n - 1)

if __name__ == '__main__':
    s = HouseRobber()
    e1 = s.rob([1,2,3,1])
    test(e1, 4)
    e2 = s.rob_top_down([1,2,3,1])
    test(e2, 4)
