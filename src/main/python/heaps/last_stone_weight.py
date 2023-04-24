from typing import *
from heapq import heappush, heappop
from shared.test import test


class LastStoneWeight:
    def lastStoneWeight(self, stones: List[int]) -> int:
        h = []
        for i in stones:
            heappush(h, -i)
        while len(h) > 1:
            h1, h2 = heappop(h), heappop(h)
            if h1 == h2:
                continue
            else:
                heappush(h, h1 - h2)
        return -h.pop() if len(h) == 1 else 0


if __name__ == "__main__":
    s = LastStoneWeight()
    e1 = s.lastStoneWeight([2, 7, 4, 1, 8, 1])
    test(e1, 1)
    e2 = s.lastStoneWeight([1, 3])
    test(e2, 2)
    e3 = s.lastStoneWeight([1])
    test(e3, 1)
    e4 = s.lastStoneWeight([1, 1])
    test(e4, 0)
    e5 = s.lastStoneWeight([1, 1, 1])
    test(e5, 1)