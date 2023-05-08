from typing import *
from collections import *
from shared.test import test


class ThreeSumSmaller:
    def threeSumSmaller(self, nums: List[int], target: int) -> int:
        count = 0
        n = len(nums)
        nums.sort()
        for i in range(n - 2):
            low = i + 1
            high = n - 1
            while low < high:
                if nums[i] + nums[low] + nums[high] < target:
                    count += high - low
                    low += 1
                else:
                    high -= 1
        return count


if __name__ == "__main__":
    s = ThreeSumSmaller()
    e1 = s.threeSumSmaller([3, 4, 2], 6)
    test(0, e1)
    e2 = s.threeSumSmaller([3, 1, 0, -2], 4)
    test(3, e2)
    e3 = s.threeSumSmaller([1, 1, -2], 1)
    test(1, e3)
    e4 = s.threeSumSmaller([1, 1, -2], 0)
    test(0, e4)
