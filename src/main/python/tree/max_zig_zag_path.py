from tree_lib import TreeNode, build_tree
from typing import Optional


class MaxZigZagPath:
    def __init__(self):
        self.pathLength = None

    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.pathLength = 0

        def dfs(node, go_left, steps):
            if node:
                self.pathLength = max(self.pathLength, steps)
                if go_left:
                    dfs(node.left, False, steps + 1)
                    dfs(node.right, True, 1)
                else:
                    dfs(node.left, False, 1)
                    dfs(node.right, True, steps + 1)

        dfs(root, False, 0)
        dfs(root, True, 0)
        return self.pathLength


if __name__ == "__main__":
    s = MaxZigZagPath()
    e1 = s.longestZigZag(
        TreeNode(1, TreeNode(1, TreeNode(1), TreeNode(1)), TreeNode(1, None, TreeNode(1, TreeNode(1), TreeNode(1))))
    )
    print(e1 == 2, e1)
    e2 = s.longestZigZag(TreeNode(1, TreeNode(1, TreeNode(1), TreeNode(1, TreeNode(1), TreeNode(1))), TreeNode(1)))
    print(e2 == 3, e2)
    e3 = s.longestZigZag(TreeNode(1))
    print(e3 == 0, e3)
    e4 = s.longestZigZag(build_tree([1, 1, None]))
    print(e4 == 1, e4)
