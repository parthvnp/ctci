from heapq import *
from shared.test import test


class NthUglyNumber:
    def nthUglyNumber(self, n: int) -> int:
        def gen_ugly_numbers(primes):
            heap = [1]
            seen = set()
            while True:
                num = heappop(heap)
                yield num
                for p in primes:
                    ugly = num * p
                    if ugly not in seen:
                        seen.add(ugly)
                        heappush(heap, ugly)

        def fetch(n):
            g = gen_ugly_numbers([2, 3, 5])
            for _ in range(n - 1):
                next(g)
            return next(g)

        return fetch(n)


if __name__ == "__main__":
    s = NthUglyNumber()
    e1 = s.nthUglyNumber(10)
    test(12, e1)
