from typing import *
from collections import *
from shared.test import test


class BulbSwitcher:
    def bulbSwitch(self, n: int) -> int:
        return int(n ** 0.5)


if __name__ == "__main__":
    s = BulbSwitcher()
    e1 = s.bulbSwitch(3)
    test(1, e1)
    e2 = s.bulbSwitch(4)
    test(2, e2)
    e3 = s.bulbSwitch(5)
    test(2, e3)
    e4 = s.bulbSwitch(100)
    test(10, e4)
    e5 = s.bulbSwitch(200)
    test(14, e5)
