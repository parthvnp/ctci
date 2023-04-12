class SimplifyPath:
    def simplifyPath(self, path: str) -> str:
        stack = []
        for char in path.split("/"):
            if char == "..":
                if stack:
                    stack.pop()
            elif char != "." and char != "":
                stack.append(char)
        return "/" + "/".join(stack) if stack else "/"


if __name__ == "__main__":
    s = SimplifyPath()
    e1 = s.simplifyPath("/home/")
    print(e1 == "/home")
    e2 = s.simplifyPath("/../")
    print(e2 == "/", e2)
    e3 = s.simplifyPath("/home//foo/")
    print(e3 == "/home/foo", e3)
    e4 = s.simplifyPath("/a/./b/../../c/")
    print(e4 == "/c", e4)
    e5 = s.simplifyPath("/a//b//c//////d")
    print(e5 == "/a/b/c/d", e5)
    e6 = s.simplifyPath(" /a/../.././../../.")
    print(e6 == "/", e6)
    e7 = s.simplifyPath("/a/../../b/../c//.//")
    print(e7 == "/c", e7)
