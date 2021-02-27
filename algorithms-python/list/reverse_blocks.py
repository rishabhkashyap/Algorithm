from typing import Optional

from list import util
from list.linked_list import LinkedList, Node


def reverse_list(head: Node, k: int) -> Optional[Node]:
    if head is None:
        return None
    rev: Optional[Node] = None
    current: Optional[Node] = head
    i: int = 0
    while (i < k) and (current is not None):
        temp:Node = current.next
        current.next = rev
        rev = current
        current = temp
        i += 1
    head.next = reverse_list(current, k)
    return rev


def main():
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))
    linked_list.add_last(Node(6))
    linked_list.add_last(Node(7))
    linked_list.add_last(Node(8))
    util.display(linked_list.head)
    head: Node = reverse_list(linked_list.head, 3)
    print("\n")
    util.display(head)


if __name__ == '__main__':
    main()
