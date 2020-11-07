from typing import Optional

from list.linked_list import LinkedList, Node


def get_middle_node(head) -> Optional[Node]:
    if head is None:
        return None
    slow_ptr: Node = head
    fast_ptr: Node = head

    while (fast_ptr is not None) and (fast_ptr.next is not None):
        slow_ptr = slow_ptr.next
        fast_ptr = fast_ptr.next.next

    return slow_ptr


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
    print(f"\nMiddle node of list = {get_middle_node(head).data}")


if __name__ == '__main__':
    main()
