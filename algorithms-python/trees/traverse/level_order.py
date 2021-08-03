"""
                        1
                    /      \
                    2        3
                  /   \\        \
                4        5       6
                                /
                               7
"""
from collections import deque
from typing import Deque

from trees.node import Node


def level_order_iteration(root: Node) -> None:
    queue: Deque[Node] = deque()
    queue.append(root)
    while queue:
        root: Node = queue.popleft()
        print(root.data, end="\t");
        if root.left is not None:
            queue.append(root.left)
        if root.right is not None:
            queue.append(root.right)


def get_height(root: Node) -> int:
    if root is None:
        return 0
    return max(get_height(root.left), get_height(root.right)) + 1


def level_order_print(root: Node, level: int) -> None:
    if root is None:
        return
    if level == 0:
        print(root.data, end="\t")
    level_order_print(root.left, level - 1)
    level_order_print(root.right, level - 1)


def level_order_recursive(root: Node) -> None:
    if root is None:
        raise ValueError("Root cannot be none")
    height: int = get_height(root)
    for i in range(0, height):
        level_order_print(root, i)


def main():
    node1: Node = Node(1)
    node2: Node = Node(2)
    node3: Node = Node(3)
    node4: Node = Node(4)
    node5: Node = Node(5)
    node6: Node = Node(6)
    node7: Node = Node(7)
    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.right = node6
    node6.left = node7
    print("Level order traversal using recursion")
    level_order_recursive(node1)
    print("\nLevel order traversal using iteration")
    level_order_iteration(node1)


if __name__ == '__main__':
    main()
