from tree_lib import TreeNode
from typing import Optional


class IsValidBST:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        in_order_traversal = []

        def inorder(root):
            if root:
                inorder(root.left)
                in_order_traversal.append(root.val)
                inorder(root.right)

        inorder(root)
        i = 1
        while i < len(in_order_traversal):
            if in_order_traversal[i - 1] >= in_order_traversal[i]:
                return False
            i += 1
        return True


if __name__ == "__main__":
    s = IsValidBST()
    e1 = s.isValidBST(TreeNode(2, TreeNode(1), TreeNode(3)))
    print(e1 is True, e1)
    e2 = s.isValidBST(TreeNode(5, TreeNode(1), TreeNode(4, TreeNode(3), TreeNode(6))))
    print(e2 is False, e2)
    e3 = s.isValidBST(TreeNode(2, TreeNode(2), TreeNode(2)))
    print(e3 is False, e3)

