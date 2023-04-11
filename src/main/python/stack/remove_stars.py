class RemoveStars:
    def removeStars(self, s: str) -> str:
        stack = []
        for char in s:
            if char != "*":
                stack.append(char)
            else:
                if stack:
                    stack.pop()
        return "".join(stack)


if __name__ == "__main__":
    s = RemoveStars()
    e1 = s.removeStars("leet**cod*e")
    print(e1 == "lecoe")
    e2 = s.removeStars("erase*****")
    print(e2 == "")
    e3 = s.removeStars("a**b**c")
    print(e3 == "c")

