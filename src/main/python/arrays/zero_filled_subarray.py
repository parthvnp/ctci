from typing import *


class ZeroFilledSubarray:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        left, right = 0, 0
        n, count = len(nums), 0
        while right < n:
            if nums[right] == 0:
                right += 1
            else:
                if nums[left] == 0 and nums[right - 1] == 0:
                    k = right - left
                    count += (k * (k + 1)) / 2
                left = right + 1
                right = right + 1
        if nums[right - 1] == 0:
            k = right - left
            count += (k * (k + 1))/2
        return int(count)


if __name__ == "__main__":
    s = ZeroFilledSubarray()
    r = s.zeroFilledSubarray([1,2,3])
    print(r)
