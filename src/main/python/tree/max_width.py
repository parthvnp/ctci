from collections import deque
from typing import Optional
from tree_lib import TreeNode, list_to_tree


class MaxWidth:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        q, max_width = deque(), 0
        q.append((root, 0))
        while q:
            _, level_head_index = q[0]
            level_size = len(q)
            for _ in range(level_size):
                node, index = q.popleft()
                if node.left:
                    q.append((node.left, index * 2))
                if node.right:
                    q.append((node.right, index * 2 + 1))
            max_width = max(max_width, index - level_head_index + 1)
        return max_width

    def maxWidthOfBinaryTreeDFS(self, root: Optional[TreeNode]) -> int:
        if not root: return 0

if __name__ == "__main__":
    s = MaxWidth()
    e1 = s.widthOfBinaryTree(TreeNode(1, TreeNode(3, TreeNode(5), TreeNode(3)), TreeNode(2, None, TreeNode(9))))
    print(e1 == 4, e1, 4)
    e2 = s.widthOfBinaryTree(TreeNode(1, TreeNode(3, TreeNode(5)), TreeNode(2)))
    print(e2 == 2, e2, 2)
    e3 = s.widthOfBinaryTree(TreeNode(1, TreeNode(3, TreeNode(5), TreeNode(3)), TreeNode(2, None, TreeNode(9))))
    e4 = s.widthOfBinaryTree(list_to_tree([1, 3, 2, 5, None, None, 9, 6, None, None, None, None, None, 7, None]))
    print(e4 == 7, e4, 7)
