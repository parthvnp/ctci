from typing import *
from collections import *
from shared.test import test


class RangeWiseBitAnd:
    def range_wise_bit_and(self, m: int, n: int):
        while n > m:
            n &= n - 1
        return m & n


if __name__ == "__main__":
    s = RangeWiseBitAnd()
    e1 = s.range_wise_bit_and(5, 7)
    test(e1, 4)
    e2 = s.range_wise_bit_and(0, 1)
    test(e2, 0)
    e3 = s.range_wise_bit_and(1, 2147483647)
    test(e3, 0)
