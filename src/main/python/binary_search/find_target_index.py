from typing import *


class FindTargetIndex:
    def targetIndices(self, nums: List[int], target: int) -> List[int]:
        nums.sort()
        left, right, ans_left, ans_right = 0, len(nums) - 1, -1, -1
        # perform two binary searches. One to find the index of the element that is the largest element smaller than
        # target. Second to find index of the element that is the smallest element larger than the target.
        # Binary Search 1:
        if nums[0] == target and nums[0] == nums[-1]:
            return list(range(len(nums)))
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] > target:
                ans_right = mid
                right = mid - 1
            else:
                left = mid + 1

        # Binary Search 2:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                ans_left = mid
                left = mid + 1
            else:
                right = mid - 1
        if ans_left == -1 and ans_right == -1:
            return []
        ans_left = ans_left + 1 if ans_left != -1 else 0
        ans_right = ans_right if ans_right != -1 else len(nums)
        return list(range(ans_left, ans_right))


if __name__ == "__main__":
    s = FindTargetIndex()
    e1 = s.targetIndices([1], 2)
    print(e1)
