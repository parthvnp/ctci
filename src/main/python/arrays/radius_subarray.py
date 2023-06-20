from typing import List
from shared.test import test


class GetAverages:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        # When a single element is considered then its average will be the number itself only.
        if k == 0:
            return nums

        n = len(nums)
        averages = [-1] * n

        # Any index will not have 'k' elements in it's left and right.
        if 2 * k + 1 > n:
            return averages

        # Generate 'prefix' array for 'nums'.
        # 'prefix[i + 1]' will be sum of all elements of 'nums' from index '0' to 'i'.
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]

        # We iterate only on those indices which have at least 'k' elements in their left and right.
        # i.e. indices from 'k' to 'n - k' (both inclusive).
        for i in range(k, n - k):
            leftBound, rightBound = i - k, i + k
            subArraySum = prefix[rightBound + 1] - prefix[leftBound]
            average = subArraySum // (2 * k + 1)
            averages[i] = average

        return averages

if __name__ == '__main__':
    s = GetAverages()
    test([-1,-1,-1,5,4,4,-1,-1,-1], s.getAverages([7,4,3,9,1,8,5,2,6], 3))
