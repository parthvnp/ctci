from typing import *
from collections import *
from shared.test import test


class RelativeRanks:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        augmented_ranks = [(i, j) for i, j in enumerate(score, 1)]
        augmented_ranks.sort(key=lambda x: x[1], reverse=True)

        def mapper(i):
            if i == 1:
                return "Gold Medal"
            elif i == 2:
                return "Silver Medal"
            elif i == 3:
                return "Bronze Medal"
            else:
                return str(i)

        ans = [""] * len(score)
        for i in range(len(augmented_ranks)):
            ans[augmented_ranks[i][0] - 1] = mapper(i + 1)
        return ans


if __name__ == "__main__":
    s = RelativeRanks()
    e1 = s.findRelativeRanks([5, 4, 3, 2, 1])
    test(["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"], e1)
    e2 = s.findRelativeRanks([10, 3, 8, 9, 4])
    test(["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"], e2)
