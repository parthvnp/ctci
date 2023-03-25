from typing import *

class TopologicalSort:
    def sort(self, n: int, edges: List[List[int]]):
        def construct():
            adj = {v: [] for v in range(n)}
            for f, j in edges: adj[j].append(f)
            return adj
        graph = construct()
        visited  = set()
        ans = []
        def dfs(vertex: int):
            visited.add(vertex)
            for k in graph[vertex]:
                if k not in visited: dfs(k)
            ans.append(vertex)
        for i in range(n):
            if i not in visited: dfs(i)
        return ans


if __name__ == '__main__':
    s = TopologicalSort()
    r = s.sort(2, [[1, 0], [0,1]])
    print(r)
