from typing import *


class UnionFind:
    def __init__(self, n):
        self._parents = [node for node in range(n)]
        self._ranks = [1 for _ in range(n)]
        self._components = n

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


class ConnectedNetwork:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n - 1:
            return -1
        union_find = UnionFind(n)
        for i, j in connections:
            union_find.union(i, j)
        return union_find.size - 1


if __name__ == "__main__":
    s = ConnectedNetwork()
    r = s.makeConnected(6, [[0, 1], [0, 2], [0, 3], [1, 2]])
    print(r)
