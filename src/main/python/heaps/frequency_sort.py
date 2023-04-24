from typing import *
from collections import Counter
from shared.test import test


class FrequencySort:
    def frequencySort(self, s: str) -> str:
        c = Counter(s)
        j = [(k, v) for k, v in c.items()]
        j.sort(key=lambda x: x[1], reverse=True)
        print(j)
        return "".join([i*j for i, j in j])


if __name__ == "__main__":
    s = FrequencySort()
    e1 = s.frequencySort("tree")
    test("eetr", e1)
    e2 = s.frequencySort("cccaaa")
    test("cccaaa", e2)
    e3 = s.frequencySort("Aabb")
    test("bbAa", e3)
    e4 = s.frequencySort("loveleetcode")
    test("eeeelloovtdc", e4)