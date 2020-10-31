from typing import Optional

from list.linked_list import Node, LinkedList


def convert_to_circular_list(node: Node) -> None:
    if node is None:
        return
    temp: Node = node
    while temp.next is not None:
        temp = temp.next

    temp.next = node


def get_fast_ptr(node: Node) -> Optional[Node]:
    if node is None:
        return None
    slow_ptr: Node = node
    fast_ptr: Node = node
    while (fast_ptr is not None) and (fast_ptr.next is not None):
        fast_ptr = fast_ptr.next.next
        slow_ptr = slow_ptr.next
        if fast_ptr == slow_ptr:
            return fast_ptr
    return None


def merge_lists(head1: Node, head2: Node) -> Optional[Node]:
    if (head1 is None) and (head2 is None):
        return None
    if head1 is None:
        return head2
    if head2 is None:
        return head1

    temp: Node = head2
    while temp.next is not None:
        temp = temp.next
    temp.next = head1
    return head2


def find_start_node(head: Node) -> Optional[Node]:
    if head is None:
        return None
    fast_ptr: Node = get_fast_ptr(head)
    if fast_ptr is None:
        return None
    slow_ptr: Node = head
    while slow_ptr != fast_ptr:
        slow_ptr = slow_ptr.next
        fast_ptr = fast_ptr.next
    return slow_ptr


def main() -> None:
    list1: LinkedList = LinkedList()
    list1.add_last(Node(1))
    list1.add_last(Node(2))
    list1.add_last(Node(3))
    list1.add_last(Node(4))
    list1.add_last(Node(5))
    head1: Node = list1.head
    convert_to_circular_list(head1)
    list2: LinkedList = LinkedList()
    list2.add_last(Node(7))
    list2.add_last(Node(8))
    list2.add_last(Node(9))
    list2.add_last(Node(10))
    head2: Node = list2.head
    head: Node = merge_lists(head1, head2)
    start_node: Node = find_start_node(head)
    if start_node is not None:
        print(f"Start node = {start_node.data}")
    else:
        print("No cycle exist")



if __name__ == '__main__':
    main()
