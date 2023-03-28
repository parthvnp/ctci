from collections import Counter
from typing import List


class DisJointSets:
    def __init__(self, N):
        self._parents = [node for node in range(N)]
        self._ranks = [1 for _ in range(N)]
        self._components = N

    @property
    def size(self):
        return self._components

    def find(self, u):
        while u != self._parents[u]:
            self._parents[u] = self._parents[self._parents[u]]
            u = self._parents[u]
        return u

    def connected(self, u, v):
        return self.find(u) == self.find(v)

    def union(self, u, v):
        root_u, root_v = self.find(u), self.find(v)
        if root_u == root_v:
            return True
        if self._ranks[root_u] > self._ranks[root_v]:
            self._parents[root_v] = root_u
        elif self._ranks[root_v] > self._ranks[root_u]:
            self._parents[root_u] = root_v
        else:
            self._parents[root_u] = root_v
            self._ranks[root_v] += 1
        self._components -= 1
        return False


class UnreachableNodes:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        if not edges: return int((n * (n - 1)) / 2)
        d = DisJointSets(n)
        for i, j in edges: d.union(i, j)
        counter = Counter([d.find(i) for i in range(n)])
        group_counts = list(counter.values())
        unreachable_pairs = (n * n - sum([k**2 for k in group_counts])) // 2
        return unreachable_pairs


if __name__ == "__main__":
    s = UnreachableNodes()
    e1 = s.countPairs(3, [[0, 1], [0, 2], [1, 2]])
    print(e1 == 0)
    e2 = s.countPairs(7, [[0, 2], [0, 5], [2, 4], [1, 6], [5, 4]])
    print(e2 == 14)
    e3 = s.countPairs(12, [])
    print(e3 == 66)
