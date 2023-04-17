from typing import *


class KidsWithCandies:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        max_candies = max(candies)
        return [i + extraCandies >= max_candies for i in candies]


if __name__ == '__main__':
    s = KidsWithCandies()
    e1  = s.kidsWithCandies([2, 3, 5, 1, 3], 3)
    print(e1 == [True, True, True, False, True])
    e2 = s.kidsWithCandies([4, 2, 1, 1, 2], 1)
    print(e2 == [True, False, False, False, False])
    e3 = s.kidsWithCandies([12, 1, 12], 10)
    print(e3 == [True, False, True])
