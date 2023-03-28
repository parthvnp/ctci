from typing import *
from collections import deque


class LongestCycle:
    def longestCycle(self, edges: List[int]) -> int:
        answer = -1

        def dfs(node, e, d, v):
            nonlocal answer
            v.add(node)
            neighbor = e[node]
            if neighbor != - 1 and neighbor not in v:
                d[neighbor] = d[node] + 1
                dfs(neighbor, e, d, v)
            elif neighbor != -1 and neighbor in d:
                answer = max(answer, d[node] - d[neighbor] + 1)

        n = len(edges)
        visited = set()
        for i in range(n):
            if i not in visited:
                dist = {i: 1}
                dfs(i, edges, dist, visited)
        return answer

    def longestCycleKahn(self, edges: List[int]) -> int:
        n = len(edges)
        visited, in_degree = set(), [0] * n
        for i in edges:
            if i != - 1: in_degree[i] += 1

        q = deque()
        for i in range(n):
            if in_degree[i] == 0: q.append(i)

        while q:
            node = q.pop()
            visited.add(node)
            neighbor = edges[node]
            if neighbor != -1:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0: q.append(neighbor)

        answer = -1
        for i in range(n):
            if i not in visited:
                neighbor, count = edges[i], 1
                visited.add(i)
                while neighbor != i:
                    visited.add(neighbor)
                    count += 1
                    neighbor = edges[neighbor]
                answer = max(answer, count)
        return answer


if __name__ == '__main__':
    s = LongestCycle()
    e1 = s.longestCycleKahn([3, 3, 4, 2, 3])
    print(e1, e1 == 3)
    e2 = s.longestCycleKahn([-1, 1, 2, 3, 4, 0])
    print(e2, e2 == 1)
    e3 = s.longestCycleKahn([2, -1, 3, 1])
    print(e3, e3 == -1)
