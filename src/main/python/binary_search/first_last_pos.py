from typing import List


class FindFirstAndLastPositionOfElementInSortedArray:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ans_left, ans_right = -1, -1
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if target == nums[mid]:
                ans_left = mid if ans_left == -1 else min(ans_left, mid)
                right = mid - 1
            elif target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if target == nums[mid]:
                ans_right = mid if ans_right == -1 else max(ans_right, mid)
                left = mid + 1
            elif target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1

        return [ans_left, ans_right]


if __name__ == "__main__":
    s = FindFirstAndLastPositionOfElementInSortedArray()
    e1 = s.searchRange([5, 7, 7, 8, 8, 10], 8)
    print(e1 == [3, 4])
    e2 = s.searchRange([5, 7, 7, 8, 8, 10], 6)
    print(e2 == [-1, -1])
    e3 = s.searchRange([], 0)
    print(e3 == [-1, -1])
    e4 = s.searchRange([1], 1)
    print(e4 == [0, 0])
    e5 = s.searchRange([1, 2, 3, 3, 3, 3, 4, 5, 9], 3)
    print(e5 == [2, 5])
    e6 = s.searchRange([3, 3, 3, 3, 3, 3, 3], 3)
    print(e6 == [0, 6])
