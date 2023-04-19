class MergeAlternately:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        i, j, r = 0, 0, []
        while i < len(word1) and j < len(word2):
            r.append(word1[i])
            r.append(word2[j])
            i += 1
            j += 1
        if i == len(word1):
            r.extend(word2[j:])
        else:
            r.extend(word1[i:])
        return "".join(r)


if __name__ == '__main__':
    s = MergeAlternately()
    e1 = s.mergeAlternately("abc", "pqr")
    print(e1 == "apbqcr", e1)
    e2 = s.mergeAlternately("ab", "pqrs")
    print(e2 == "apbqrs", e2)
    e3 = s.mergeAlternately("abcd", "pq")
    print(e3 == "apbqcd", e3)
