from functools import cache
from shared.test import test


class MinInsertionsToPalindrome:
    @cache
    def minInsertions(self, s: str) -> int:
        if len(s) <= 1:
            return 0
        if s[0] == s[-1]:
            return self.minInsertions(s[1:-1])
        else:
            return 1 + min(self.minInsertions(s[1:]), self.minInsertions(s[:-1]))


if __name__ == "__main__":
    s = MinInsertionsToPalindrome()
    e1 = s.minInsertions("zzazz")
    test(e1, 0)
    e2 = s.minInsertions("mbadm")
    test(e2, 2)
    e3 = s.minInsertions("leetcode")
    test(e3, 5)
    e4 = s.minInsertions("g")
    test(e4, 0)
    e5 = s.minInsertions("no")
    test(e5, 1)
    e6 = s.minInsertions("zjveiiwvc")
    test(e6, 5)

