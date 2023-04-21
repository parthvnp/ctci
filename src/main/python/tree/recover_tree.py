from tree_lib import TreeNode, list_to_tree, level_order, inorder
from typing import Optional


class RecoverTree:
    def recoverTree(self, root):
        def find_two_swapped(root: TreeNode):
            nonlocal x, y, pred
            if root is None:
                return

            find_two_swapped(root.left)
            if pred and root.val < pred.val:
                y = root
                # first swap occurrence
                if x is None:
                    x = pred
                    # second swap occurrence
                else:
                    return
            pred = root
            find_two_swapped(root.right)

        x = y = pred = None
        find_two_swapped(root)
        x.val, y.val = y.val, x.val


if __name__ == '__main__':
    s = RecoverTree()
    t1 = list_to_tree([1, 3, None, None, 2])
    print(inorder(t1))
    s.recoverTree(t1)
