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
from typing import Optional, Deque

from trees.node import Node


def postorder3(root: Optional[Node]) -> None:
    if root is None:
        raise ValueError("Root element is none")
    stack: Deque[Node] = deque()
    while True:
        while root is not None:
            if root.right is not None:
                stack.append(root.right)
            stack.append(root)
            root = root.left
        if deque:
            root = stack.pop()
        # if top element of stack is right of popped element
        # then put root back and process right node
        if stack and root.right == stack[-1]:
            stack.pop()
            stack.append(root)
            root = root.right
        else:
            print(root.data, end="\t")
            root = None
        if not stack:
            break


# Iteration and using 2 stacks

def postorder2(root: Optional[Node]) -> None:
    if root is None:
        raise ValueError("Root is None")
    stack: Deque[Node] = deque()
    result: Deque[Node] = deque()
    stack.append(root)
    while stack:
        node: Node = stack.pop()
        result.append(node)
        if node.left is not None:
            stack.append(node.left)
        if node.right is not None:
            stack.append(node.right)
    while result:
        print(result.pop().data, end="\t")


# Recursion
def postorder1(root: Optional[Node]) -> None:
    if root is None:
        return
    postorder1(root.left)
    postorder1(root.right)
    print(root.data, end="\t")


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
    postorder1(node1)
    print()
    postorder2(node1)
    print()
    postorder3(node1)


if __name__ == '__main__':
    main()
