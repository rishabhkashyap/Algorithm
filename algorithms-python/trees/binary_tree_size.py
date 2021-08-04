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
from trees.traverse.postorder_traversal import postorder3

from trees.node import Node


def size_recursion(root: Node) -> int:
    if root is None:
        return 0;
    left: int = size_recursion(root.left)
    right: int = size_recursion(root.right)
    return left + right + 1


def size_iteration(root: Node) -> int:
    stack: Deque[Node] = deque()
    count: int = 0
    while True:
        while root is not None:
            if root.right is not None:
                stack.append(root.right)
            stack.append(root)
            root = root.left

        if stack:
            root = stack.pop()
            if stack and (root.right == stack[-1]):
                stack.pop()
                stack.append(root)
                root = root.right
            else:
                count += 1
                root = None
        else:
            break
    return count


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
    print(f"Size of binary tree recursion = {size_recursion(node1)}")
    print(f"\nSize of binary tree iteration = {size_iteration(node1)}")


if __name__ == '__main__':
    main()
