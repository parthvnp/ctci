from typing import *

from tree_lib import inorder, TreeNode


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def build(low, high) -> Optional[TreeNode]:
            nonlocal index
            if low > high: return None
            root_val = postorder[-index]
            root = TreeNode(root_val)
            root_idx = inorder_idx_map[root_val]
            index += 1
            root.right = build(root_idx + 1, high)
            root.left = build(low, root_idx - 1)
            return root

        index = 1
        inorder_idx_map = {j: i for i, j in enumerate(postorder)}
        return build(0, len(inorder) - 1)


if __name__ == "__main__":
    inorder = [1, 2, 3, 4]
    postorder = [2, 1, 4, 3]
    s = Solution()
    r = s.buildTree(inorder, postorder)
    inorder(r)
