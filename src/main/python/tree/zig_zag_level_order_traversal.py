from typing import *
from collections import deque
from tree_lib import TreeNode, list_to_tree
from shared.test import test

class ZigZagLevelOrderTraversal:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None: return []
        q = deque()
        q.append(root)
        flip, ans = False, []
        while q:
            size = len(q)
            if flip: start, end, step = size - 1, -1, -1
            else: start, end, step = 0, size, 1
            t = [-1] * size
            for i in range(start, end, step):
                node = q.popleft()
                t[i] = node.val
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            flip = not flip
            ans.append(t)
        return ans

if __name__ == '__main__':
    s = ZigZagLevelOrderTraversal()
    e1 = s.zigzagLevelOrder(list_to_tree([3,9,20,None,None,15,7]))
    test([[3],[20,9],[15,7]], e1)
    e2 = s.zigzagLevelOrder(list_to_tree([1]))
    test([[1]], e2)
    e3 = s.zigzagLevelOrder(list_to_tree([]))
    test([], e3)
    e4 = s.zigzagLevelOrder(list_to_tree([1,2,3,4,None,None,5]))
    test([[1],[3,2],[4,5]], e4)
