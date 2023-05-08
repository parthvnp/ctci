from typing import *
from collections import *
from shared.test import test


class ThreeSum:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # we will sort the array first and then search for complements of nums[i] in the remaining array
        # using two sum
        # we avoid including duplicate values by skipping over the low-end value in two pointer search
        res = []

        def twoPointerSearch(n, left):
            nonlocal res
            low, high = left + 1, len(n) - 1
            while low < high:
                triplet_sum = nums[left] + nums[low] + nums[high]
                if triplet_sum > 0:
                    high -= 1
                elif triplet_sum < 0:
                    low += 1
                else:
                    res.append([n[left], n[low], n[high]])
                    low += 1
                    high -= 1
                    while low < high and nums[low] == nums[low - 1]:
                        low += 1

        nums.sort()
        for i, j in enumerate(nums):
            if j > 0:
                break
            if i == 0 or nums[i - 1] != nums[i]:
                twoPointerSearch(nums, i)
        return res


if __name__ == "__main__":
    s = ThreeSum()
    e1 = s.threeSum([-1, 0, 1, 2, -1, -4])
    test([[-1, -1, 2], [-1, 0, 1]], e1)
    e2 = s.threeSum([])
    test([], e2)
    e3 = s.threeSum([0])
    test([], e3)
    e4 = s.threeSum([0, 0, 0])
    test([[0, 0, 0]], e4)
    e5 = s.threeSum([-2, 0, 0, 2, 2])
    test([[-2, 0, 2]], e5)
    e6 = s.threeSum([-2, 0, 1, 1, 2])
    test([[-2, 0, 2], [-2, 1, 1]], e6)
    e7 = s.threeSum([-2, 0, 0, 2, 2])
    test([[-2, 0, 2]], e7)
    e8 = s.threeSum([-2, 0, 0, 2, 2, 2])
    test([[-2, 0, 2]], e8)

