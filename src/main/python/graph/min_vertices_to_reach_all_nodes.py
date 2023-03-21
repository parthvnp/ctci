from typing import *


class MinVerticesToReachAllNodes:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        t = [0] * n
        for i, j in edges: t[j] += 1
        return [i for i, j in enumerate(t) if not j]


if __name__ == '__main__':
    s = MinVerticesToReachAllNodes()
    r = s.findSmallestSetOfVertices(6, [[0, 1], [0, 2], [2, 5], [3, 4], [4, 2]])
    print(r)
