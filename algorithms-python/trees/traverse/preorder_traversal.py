from trees.node import Node
from collections import deque

'''
                        1
                     /      \
                    2        3
                  /   \        \
                4        5       6
                                /
                               7           
'''


def preorder2(node1):
    pass


def preorder1(root: Node) -> Node:
    if root is None:
        return
    print(root.data, end="\t")
    preorder1(root.left)
    preorder1(root.right)


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
    preorder1(node1)
    preorder2(node1)


if __name__ == '__main__':
    main()
