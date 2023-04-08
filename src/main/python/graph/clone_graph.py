from collections import deque
from typing import *
from libgraph import construct


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

    def __repr__(self):
        return f"{self.val} {self.neighbors}"

    def __str__(self):
        return f"{self.val} {self.neighbors}"


class CloneGraph:
    def cloneGraph(self, node: 'Node') -> 'Node':
        d, node_map = deque(), {}
        d.append(node)
        node_map[node.val] = Node(node.val)
        while d:
            curr = d.pop()
            for n in curr.neighbors:
                if n.val not in node_map:
                    node_map[n.val] = Node(n.val)
                    d.append(n)
                node_map[curr.val].neighbors.append(node_map[n.val])
        return node_map[node.val]


if __name__ == '__main__':
    s = CloneGraph()
    g = construct([[2, 4], [1, 3], [2, 4], [1, 3]], 1)
    print(g)
    r = s.cloneGraph([[2, 4], [1, 3], [2, 4], [1, 3]])
    print(r)
