from typing import *
from collections import defaultdict


class AllPaths:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        visited = [False] * len(graph)
        path = []
        all_paths = []
        size = len(graph)

        def construct(adj):
            adj_list = defaultdict(list)
            for i, j in enumerate(adj):
                adj_list[i].extend(j[:])
            return adj_list

        g = construct(graph)

        def dfs(root, index):
            nonlocal size
            if index == size - 1:
                all_paths.append(path[:])
                path.pop()
                return

            visited[index] = True
            for n in root[index]:
                path.append(n)
                dfs(root, n)
            path.pop()
        path.append(0)

        dfs(g, index=0)
        return all_paths


if __name__ == '__main__':
    s = AllPaths()
    r = s.allPathsSourceTarget([[4, 3, 1], [3, 2, 4], [3], [4], []])
    print(r)
