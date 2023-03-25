from typing import *
from collections import defaultdict


class FindOrder:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        def construct():
            adj = defaultdict(list)
            for u, j in prerequisites: adj[j].append(u)
            return adj

        graph = construct()
        ans = []
        visited = set()

        tracker = [0] * numCourses

        def has_cycle(index):
            if tracker[index] == 1: return False
            if tracker[index] == -1: return True
            tracker[index] = - 1
            for n in graph[index]:
                if has_cycle(n): return True
            tracker[index] = 1

        def dfs(vertex: int):
            visited.add(vertex)
            for k in graph[vertex]:
                if k not in visited: dfs(k)
            ans.append(vertex)

        for i in range(numCourses):
            if has_cycle(i): return []

        for i in range(numCourses):
            if i not in visited: dfs(i)

        return ans[::-1] if len(ans) == numCourses else []


if __name__ == '__main__':
    s = FindOrder()
    e1 = s.findOrder(2, [[1, 0], [0, 1]])
    print(e1)
    print(e1 == [])
    e2 = s.findOrder(4, [[1, 0], [2, 0], [3, 1], [3, 2]])
    print(e2 == [0, 1, 2, 3] or e2 == [0, 2, 1, 3], e2)
    e3 = s.findOrder(1, [])
    print(e3 == [0])
