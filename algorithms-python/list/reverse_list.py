from typing import Optional

from list import util
from list.linked_list import LinkedList, Node


def reverse_list_iteration(head: Node) -> Node:
    if head is None:
        raise ValueError("Head node cannot be null")
    temp: Node = head
    reverse_head: Optional[Node] = None
    while temp is not None:
        next_node: Node = temp.next
        temp.next = reverse_head
        reverse_head = temp
        temp = next_node
    return reverse_head


def reverse_list_recursion(head: Node) -> Node:
    if (head is None) or (head.next is None):
        return head
    reverse_head: Node = reverse_list_iteration(head.next)
    head.next.next = head
    head.next = None
    return reverse_head


def main():
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))
    linked_list.add_last(Node(6))
    linked_list.display()
    # head: Node = reverse_list_iteration(linked_list.head)
    head: Node = reverse_list_recursion(linked_list.head)
    print("\n")
    util.display(head)


if __name__ == '__main__':
    main()
