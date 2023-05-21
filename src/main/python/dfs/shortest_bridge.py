from itertools import product
from typing import *
from collections import *
from shared.test import test


class ShortestBridge:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        # first we need to find one of the two island. We use dfs here. Essentially
        # the idea here is to start from a cell that is an island and visit all the neighboring cells till we have
        # reached the edge of the island, i.e. there are no more 1s. Once this first island is found we stop searching.

        def dfs(i, j):
            if i < 0 or j < 0 or i >= m or j >= n or (i, j) in seen or grid[i][j] != 1: return
            seen.add((i, j))
            q.append((i, j, 0))
            grid[i][j] = -1
            list(map(dfs, (i + 1, i - 1, i, i), (j, j, j + 1, j - 1)))

        seen, q, m, n = set(), deque(), len(grid), len(grid[0])
        for i, j in product(range(m), range(n)):
            if grid[i][j]:
                dfs(i, j)
                break

        while q:
            i, j, h = q.popleft()
            if grid[i][j] == 1:
                return h - 1
            for x, y in (i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1):
                if 0 <= x < m and 0 <= y < n and (x, y) not in seen:
                    seen.add((x, y))
                    q += (x, y, h + 1),
        return -1


if __name__ == "__main__":
    s = ShortestBridge()
    e1 = s.shortestBridge([[0, 1], [1, 0]])
    test(1, e1)
    e2 = s.shortestBridge([[0, 1, 0], [0, 0, 0], [0, 0, 1]])
    test(2, e2)
    e3 = s.shortestBridge([[1, 1, 1, 1, 1], [1, 0, 0, 0, 1], [1, 0, 1, 0, 1], [1, 0, 0, 0, 1], [1, 1, 1, 1, 1]])
    test(1, e3)
