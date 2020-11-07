from typing import Optional

from list.linked_list import LinkedList, Node


def reverse1(head) -> Optional[Node]:
    if head is None:
        return None
    temp: Node = head
    reverse_head: Optional[Node] = None
    while temp is not None:
        nxt: Node = temp.next
        temp.next = reverse_head
        reverse_head = temp
        temp = nxt
    return reverse_head


def reverse2(head) -> Optional[Node]:
    if (head is None) or (head.next is None):
        return head
    reverse_head: Optional[Node] = reverse2(head.next)
    head.next.next = head
    head.next = None
    return reverse_head


def display(head: Node) -> None:
    if head is None:
        return
    temp: Node = head
    while temp is not None:
        print(temp.data, end="\t")
        temp = temp.next


def main():
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))
    linked_list.add_last(Node(6))
    head: Node = linked_list.head
    display(head)
    head = reverse1(head)
    print()
    display(head)
    head = reverse2(head)
    print()
    display(head)


if __name__ == '__main__':
    main()
