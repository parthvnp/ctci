class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

    def __repr__(self):
        return f"{self.val} {self.neighbors}"

    def __str__(self):
        return f"{self.val} {self.neighbors}"

def show_graph(node):
    visited = set()
    def show(n):
        print(n)
        visited.add(n.val)
        for i in n.neighbors: show(i)


def construct(edges, start):
    node_map = {}
    for i,j in edges:
        if i not in node_map: node_map[i] = Node(i)
        if j not in node_map: node_map[j] = Node(j)
        node_map[i].neighbors.append(node_map[j])
    return node_map[start]
