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

from trees.node import Node


def max_element(root: Node) -> int:
    if root is None:
        return -math.inf
    left: int = max_element(root.left)
    right: int = max_element(root.right)
    return max(max(right, left), root.data)


def min_element(root: Node) -> int:
    if root is None:
        return math.inf
    left: int = max_element(root.left)
    right: int = max_element(root.right)
    return min(min(right, left), root.data)


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
    print(f"Max element in tree = {max_element(node1)}")
    print(f"Min element in tree = {min_element(node1)}")


if __name__ == '__main__':
    main()
