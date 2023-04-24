from shared.test import test


class IsUgly:
    def isUgly(self, n: int) -> bool:
        def keepDividingWhenDivisible(dividend, divisor):
            while dividend % divisor == 0: dividend = dividend / divisor
            return dividend

        for i in (2, 3, 5):
            n = keepDividingWhenDivisible(n, i)
        return n == 1


if __name__ == '__main__':
    s = IsUgly()
    e1 = s.isUgly(6)
    test(True, e1)
    e2 = s.isUgly(8)
    test(True, e2)
    e3 = s.isUgly(14)
    test(False, e3)
