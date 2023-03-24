from typing import *


class UniqueMorseCode:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        morse_code = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                      "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]

        def build_code(word):
            s = ""
            for i in word: s += morse_code[ord(i) - 97]
            return s

        def count_transformations(words):
            print([build_code(w) for w in words])
            return len(set([build_code(w) for w in words]))

        return count_transformations(words)


if __name__ == "__main__":
    s = UniqueMorseCode()
    r = s.uniqueMorseRepresentations(["a"])
    print(r)
