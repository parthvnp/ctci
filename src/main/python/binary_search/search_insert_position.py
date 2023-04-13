from typing import List


class SearchInsertPosition:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left)//2
            if nums[mid] == target: return mid
            elif target > nums[mid]: left = mid + 1
            else: right = mid - 1
        return left

if __name__ == '__main__':
    s = SearchInsertPosition()
    e1 = s.searchInsert([1, 3, 5, 6], 5)
    print(e1 == 2)
    e2 = s.searchInsert([1, 3, 5, 6], 2)
    print(e2 == 1)
