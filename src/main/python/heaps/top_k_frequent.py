from heapq import heappush, heappop
from collections import Counter
from typing import List
from shared.test import test


class TopKFrequent:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        c = Counter(nums)
        heap = []
        for key, value in c.items():
            heappush(heap, (-value, key))
        ans = []
        for _ in range(k):
            ans.append(heappop(heap)[1])
        return ans


if __name__ == "__main__":
    s = TopKFrequent()
    e1 = s.topKFrequent([1, 1, 1, 2, 2, 3], 2)
    test([1, 2], e1)
    e2 = s.topKFrequent([1], 1)
    test([1], e2)
    e3 = s.topKFrequent([1, 2], 2)
    test([1, 2], e3)

