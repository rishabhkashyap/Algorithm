"""
                        1
                    /      \
                    2        3
                  /   \\        \
                4        10       6
                                /
                               7
"""
from collections import deque
from typing import Deque

from trees.node import Node
from trees.traverse.preorder_traversal import preorder1


def insert(root: Node, node: Node) -> Node:
    if root is None:
        return node
    queue: Deque[Node] = deque()
    queue.append(root)
    while queue:
        current: Node = queue.popleft()
        if current.left is None:
            current.left = node
            break
        else:
            queue.append(current.left)
        if current.right is None:
            current.right = node
            break
        else:
            queue.append(current.right)
    return root


def main():
    node1: Node = Node(1)
    node2: Node = Node(2)
    node3: Node = Node(3)
    node4: Node = Node(4)
    node10: Node = Node(10)
    node6: Node = Node(6)
    node7: Node = Node(7)
    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node10
    node3.right = node6
    node6.left = node7
    preorder1(node1)
    print()
    root: Node = insert(node1, Node(25))
    preorder1(root)


if __name__ == '__main__':
    main()
