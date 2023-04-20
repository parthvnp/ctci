from collections import deque
from typing import Optional
from tree_lib import TreeNode, list_to_tree


class MaxWidth:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        q = deque()
        q.append((root, 0))
        max_width = 0
        while q:
            level_length = len(q)
            _, level_head_index = q[0]
            for _ in range(level_length):
                node, col_index = q.popleft()
                if node.left:
                    q.append((node.left, 2 * col_index))
                if node.right:
                    q.append((node.right, 2 * col_index + 1))
            max_width = max(max_width, col_index - level_head_index + 1)
        return max_width


if __name__ == "__main__":
    s = MaxWidth()
    e1 = s.widthOfBinaryTree(TreeNode(1, TreeNode(3, TreeNode(5), TreeNode(3)), TreeNode(2, None, TreeNode(9))))
    print(e1 == 4, e1, 4)
    e2 = s.widthOfBinaryTree(TreeNode(1, TreeNode(3, TreeNode(5)), TreeNode(2)))
    print(e2 == 2, e2, 2)
    e3 = s.widthOfBinaryTree(TreeNode(1, TreeNode(3, TreeNode(5), TreeNode(3)), TreeNode(2, None, TreeNode(9))))
    e4 = s.widthOfBinaryTree(list_to_tree([1, 3, 2, 5, None, None, 9, 6, None, None, None, None, None, None, 7]))
    print(e4 == 7, e4, 7)
