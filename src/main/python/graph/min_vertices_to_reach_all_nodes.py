from typing import *
from shared.test import test

class MinVerticesToReachAllNodes:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        t = [0] * n
        for i, j in edges: t[j] += 1
        return [i for i, j in enumerate(t) if not j]


if __name__ == '__main__':
    s = MinVerticesToReachAllNodes()
    e1 = s.findSmallestSetOfVertices(6, [[0, 1], [0, 2], [2, 5], [3, 4], [4, 2]])
    test([0, 3], e1)
    e2 = s.findSmallestSetOfVertices(5, [[0, 1], [2, 1], [3, 1], [1, 4], [2, 4]])
    test([0, 2, 3], e2)
    e3 = s.findSmallestSetOfVertices(5, [[0, 1], [2, 1], [3, 1], [1, 4], [2, 4], [4, 3]])
    test([0, 2], e3)

