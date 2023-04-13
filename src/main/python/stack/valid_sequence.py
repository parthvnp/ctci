from typing import List


class ValidStackSequence:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        i = 0
        for num in pushed:
            stack.append(num)
            while len(stack) > 0 and stack[len(stack) - 1] == popped[i]:
                stack.pop()
                i += 1
        return len(stack) == 0


if __name__ == '__main__':
    s = ValidStackSequence()
    e1 = s.validateStackSequences([1, 2, 3, 4, 5], [4, 5, 3, 2, 1])
    print(e1)
    e2 = s.validateStackSequences([1, 2, 3, 4, 5], [4, 3, 5, 1, 2])
    print(e2)
