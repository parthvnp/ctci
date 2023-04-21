from shared.test import test


class Tribonacci:
    def tribonacci(self, n: int) -> int:
        if n == 0: return 0
        if n == 1 or n == 2: return 1
        t0, t1, t2 = 0, 1, 1
        for _ in range(3, n + 1): t0, t1, t2 = t1, t2, t0 + t1 + t2
        return t2


if __name__ == '__main__':
    s = Tribonacci()
    e1 = s.tribonacci(4)
    test(e1, 4)
    e2 = s.tribonacci(25)
    test(e2, 1389537)
