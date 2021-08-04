"""
                        1
                    /      \
                    2        3
                  /   \\        \
                4        10       6
                                /
                               7
"""
import math
from collections import deque
from typing import Deque

from trees.node import Node


def max_element_recursion(root: Node) -> int:
    if root is None:
        return -math.inf
    left: int = max_element_recursion(root.left)
    right: int = max_element_recursion(root.right)
    return max(max(right, left), root.data)


def min_element(root: Node) -> int:
    if root is None:
        return math.inf
    left: int = max_element_recursion(root.left)
    right: int = max_element_recursion(root.right)
    return min(min(right, left), root.data)


def max_element_iteration(root: Node) -> int:
    stack: Deque[Node] = deque()
    stack.append(root)
    max_element: int = -math.inf
    while stack:
        node: Node = stack.pop()
        max_element = max(max_element, node.data)
        if node.right is not None:
            stack.append(node.right)
        if node.left is not None:
            stack.append(node.left)

    return max_element


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
    print(f"Max element in tree using recursion = {max_element_recursion(node1)}")
    print(f"Max element in tree using iteration = {max_element_iteration(node1)}")
    print(f"Min element in tree = {min_element(node1)}")


if __name__ == '__main__':
    main()
