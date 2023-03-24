from typing import *


class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        def construct():
            adj = {i: [] for i in range(n)}
            for i, j in connections:
                adj[j].append((i, 0))
                adj[i].append((j, 1))
            return adj

        graph = construct()
        print(graph)
        count = 0
        visited = set()

        def dfs(vertex):
            nonlocal count
            visited.add(vertex)
            for i in graph[vertex]:
                if i[0] not in visited:
                    count += i[1]
                    dfs(i[0])

        dfs(0)
        return count


if __name__ == '__main__':
    s = Solution()
    e1 = s.minReorder(5, [[1, 0], [1, 2], [3, 2], [3, 4]])
    e2 = s.minReorder(6, [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]])
    e3 = s.minReorder(3, [[1, 0], [2, 0]])
    print(e1 == 2)
    print(e2 == 3)
    print(e3 == 0)
