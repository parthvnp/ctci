from typing import *
from collections import *
from shared.test import test
from heapq import heappush, heappop


class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.heap = []
        for n in nums:
            heappush(self.heap, n)

    def add(self, val: int) -> int:
        heappush(self.heap, val)
        print(self.heap)
        return self.heap[-self.k]


if __name__ == "__main__":
    s = KthLargest(3, [4, 5, 8, 2])
    e1 = s.add(3)
    test(4, e1)
    e2 = s.add(5)
    test(5, e2)
    e3 = s.add(10)
    test(5, e3)
    e4 = s.add(9)
    test(8, e4)
    e5 = s.add(4)
    test(8, e5)
