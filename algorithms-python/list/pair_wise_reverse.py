from typing import Optional

from list import util
from list.linked_list import LinkedList, Node


def pairwise_reverse(head: Node) -> Node:
    if head is None:
        raise ValueError("Head node cannot be none")

    rev_head: Node = head.next
    current: Optional[Node] = head
    node1: Node = current.next
    node2: Node = node1.next
    while True:
        node1.next = current
        if (node2 is None) or (node2.next is None):
            current.next = node2
            break
        current.next = node2.next
        current = node2
        node1 = node2.next
        node2 = node2.next.next
    return rev_head


def main():
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))
    linked_list.add_last(Node(6))
    linked_list.add_last(Node(7))
    # linked_list.add_last(Node(8))
    util.display(linked_list.head)
    print("\n\nList after pair wise display")
    head: Node = pairwise_reverse(linked_list.head)
    util.display(head)


if __name__ == '__main__':
    main()
