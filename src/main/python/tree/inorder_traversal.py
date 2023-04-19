from tree_lib import TreeNode
from typing import *


class InorderTraversal:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        def inorder(rt):
            if rt:
                inorder(rt.left)
                res.append(rt.val)
                inorder(rt.right)

        inorder(root)
        return res


if __name__ == "__main__":
    s = InorderTraversal()
    e1 = s.inorderTraversal(TreeNode(1, None, TreeNode(2, TreeNode(3), None)))
    print(e1 == [1, 3, 2], e1)
