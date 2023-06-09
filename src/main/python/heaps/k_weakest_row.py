from typing import *
from collections import *
from shared.test import test
import heapq


class KWeakestRows:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        m = len(mat)
        n = len(mat[0])

        def binary_search(row):
            low = 0
            high = n
            while low < high:
                mid = low + (high - low) // 2
                if row[mid] == 1:
                    low = mid + 1
                else:
                    high = mid
            return low

        pq = []
        for i, row in enumerate(mat):
            strength = binary_search(row)
            entry = (-strength, -i)
            if len(pq) < k or entry > pq[0]:
                heapq.heappush(pq, entry)
            if len(pq) > k:
                heapq.heappop(pq)

        indexes = []
        while pq:
            strength, i = heapq.heappop(pq)
            indexes.append(-i)

        indexes = indexes[::-1]

        return indexes


if __name__ == "__main__":
    s = KWeakestRows()
    e1 = s.kWeakestRows([[1, 1, 0, 0, 0], [1, 1, 1, 1, 0], [1, 0, 0, 0, 0], [1, 1, 0, 0, 0], [1, 1, 1, 1, 1]], 3)
    test(e1, [2, 0, 3])
