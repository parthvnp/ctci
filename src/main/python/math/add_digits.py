from typing import *
from collections import *
from shared.test import test


class AddDigits:
    def addDigits(self, num: int) -> int:
        while num // 10 > 0:
            x = num
            s = 0
            while x != 0:
                s += x % 10
                x = x // 10
            num = s
        return num


if __name__ == "__main__":
    s = AddDigits()
    e1 = s.addDigits(38)
    test(2, e1)
    e2 = s.addDigits(0)
    test(0, e2)
    e3 = s.addDigits(1)
    test(1, e3)
    e4 = s.addDigits(10)
    test(1, e4)
    e5 = s.addDigits(11)
    test(2, e5)
