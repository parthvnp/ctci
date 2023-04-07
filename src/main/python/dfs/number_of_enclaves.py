from typing import *


class NumberOfEnclaves:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        def dfs(r, c):
            # if out of bounds or 0 return
            if r < 0 or c < 0 or r == len(grid) or c == len(grid) or grid[r][c] != 1:
                return
            # if 1, set it to 0
            grid[r][c] = 0
            # call dfs on all the neighbors
            dfs(r + 1, c), dfs(r - 1, c), dfs(r, c + 1), dfs(r, c - 1)

        # convert all the 1's that are connected to the boundary to 0's
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i * j == 0 or i == len(grid) - 1 or j == len(grid[0]) - 1:
                    dfs(i, j)

        # count the entries in the grid that are 1s
        return sum([sum(row) for row in grid])


if __name__ == "__main__":
    s = NumberOfEnclaves()
    e1 = s.numEnclaves([[0, 0, 0, 0], [1, 0, 1, 0], [0, 1, 1, 0], [0, 0, 0, 0]])
    print(e1 == 3)
    e2 = s.numEnclaves([[0, 1, 1, 0], [0, 0, 1, 0], [0, 0, 1, 0], [0, 0, 0, 0]])
    print(e2 == 0)
