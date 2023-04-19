def print_inorder(root):
    if root:
        print_inorder(root.left)
        print(root.val)
        print_inorder(root.right)


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def build_tree(traversal) -> TreeNode:
    if not traversal:
        return None
    root = TreeNode(traversal[0])
    queue = [root]
    i = 1
    while i < len(traversal):
        node = queue.pop(0)
        if traversal[i] is not None:
            node.left = TreeNode(traversal[i])
            queue.append(node.left)
        i += 1
        if i < len(traversal) and traversal[i] is not None:
            node.right = TreeNode(traversal[i])
            queue.append(node.right)
        i += 1
    return root
