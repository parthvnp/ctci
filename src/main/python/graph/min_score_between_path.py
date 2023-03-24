import math
from typing import *
from collections import defaultdict


class MinScoreBetweenPath:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        min_val = math.inf
        visited = set()

        def construct(road_list):
            adj = defaultdict(list)
            for i in road_list:
                adj[i[0]].append((i[1], i[2]))
                adj[i[1]].append((i[0], i[2]))
            return adj

        g = construct(roads)

        def dfs(graph, index):
            nonlocal min_val
            if index in visited:
                return
            visited.add(index)
            for i in graph[index]:
                min_val = min((min_val, i[1]))
                dfs(graph, i[0])

        dfs(g, 1)
        return int(min_val)


if __name__ == "__main__":
    s = MinScoreBetweenPath()
    r = s.minScore(4, [[1, 2, 2], [1, 3, 4], [3, 4, 7]])
    print(r)
