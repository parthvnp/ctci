from typing import List
from collections import Counter
from shared.test import test


class DeleteAndEarn:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        max_val = max(nums)
        freq = Counter(nums)
        dp = [0] * (max_val + 1)
        dp[1] = freq[1]
        for i in range(2, max_val + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + freq[i] * i)
        return dp[max_val]


if __name__ == '__main__':
    s = DeleteAndEarn()
    e1 = s.deleteAndEarn([3, 4, 2])
    test(6, e1)
    e2 = s.deleteAndEarn([2, 2, 3, 3, 3, 4])
    test(9, e2)
    e3 = s.deleteAndEarn([1, 1, 1, 2, 4, 5, 5, 5, 6])
    test(18, e3)
    e4 = s.deleteAndEarn([1, 1, 1, 2, 4, 5, 5, 5, 6, 6, 6])
    test(24, e4)
    e5 = s.deleteAndEarn([1, 1, 1, 2, 4, 5, 5, 5, 6, 6, 6, 7])
    test(25, e5)
    e6 = s.deleteAndEarn([1, 1, 1, 2, 4, 5, 5, 5, 6, 6, 6, 7, 8])
    test(33, e6)


