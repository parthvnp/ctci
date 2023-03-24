class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False

    def __str__(self):
        return f"{self.children}"

    def __repr__(self):
        return f"{self.children}"


class WordDictionary:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        curr = self.root
        for i in word:
            if i not in curr.children:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.is_word = True

    def search(self, word: str) -> bool:
        curr = self.root
        if "." in word: return self.search_pattern(word, self.root)
        for i in word:
            if i == "." and curr.children:
                curr = curr.children[next(iter(curr.children))]
            else:
                if i not in curr.children:
                    return False
                curr = curr.children[i]
        return curr.is_word

    def search_pattern(self, word: str, curr: TrieNode) -> bool:
        if not curr:
            return False
        if curr.children:
            return curr.is_word
        for i in word:
            if i == ".":
                for k in curr.children:
                    return self.search_pattern(word, curr.children[k])
            else:
                if i not in curr.children:
                    return False
                else:
                    curr = curr.children[i]
        return curr.is_word


def executor(cmds, args, ob):
    for c, a in zip(cmds, args):
        if c == "addWord":
            ob.addWord(a[0])
            print(None, end=" ")
        elif c == "search":
            print(ob.search(c), end=" ")


if __name__ == "__main__":
    # [[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
    obj = WordDictionary()
    cmds = [
        "WordDictionary",
        "addWord",
        "addWord",
        "addWord",
        "addWord",
        "search",
        "search",
        "addWord",
        "search",
        "search",
        "search",
        "search",
        "search",
        "search",
    ]
    args = [
        [],
        ["at"],
        ["and"],
        ["an"],
        ["add"],
        ["a"],
        [".at"],
        ["bat"],
        [".at"],
        ["an."],
        ["a.d."],
        ["b."],
        ["a.d"],
        ["."],
    ]
    executor(cmds, args, obj)
    print()
    print(obj.search_pattern("a.d", obj.root))
