from collections import deque


def inorder(root):
    values = []

    def traverse(rt):
        if rt:
            traverse(rt.left)
            values.append(rt.val)
            traverse(rt.right)

    traverse(root)
    return values


def level_order(root):
    values = []

    def traverse(rt):
        if not rt:
            return
        q = deque()
        q.append(rt)
        while q:
            node = q.popleft()
            values.append(node.val)
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)

    traverse(root)
    return values


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


def list_to_tree(lst, index=0):
    if index >= len(lst) or lst[index] is None:
        return None

    root = TreeNode(lst[index])
    root.left = list_to_tree(lst, 2 * index + 1)
    root.right = list_to_tree(lst, 2 * index + 2)

    return root
