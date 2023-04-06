from typing import *


class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        DIR = [0, 1, 0, -1, 0]

        def dfs(r, c):
            grid[r][c] = -1
            isClosedIsland = 1
            for i in range(4):
                nr, nc = r + DIR[i], c + DIR[i + 1]
                if not (0 <= nr < m and 0 <= nc < n):  # This is not the closed island anymore!
                    isClosedIsland = 0
                elif grid[nr][nc] == 0:
                    if dfs(nr, nc) == 0:
                        isClosedIsland = 0
            return isClosedIsland

        nClosedIsland = 0
        for r in range(m):
            for c in range(n):
                if grid[r][c] == 0:
                    nClosedIsland += dfs(r, c)
        return nClosedIsland
