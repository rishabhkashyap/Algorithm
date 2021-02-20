from list import util
from list.linked_list import Node, LinkedList


def is_len_even(node: Node, head: Node):
    return node == head


def get_mid_node(head) -> Node:
    slow: Node = head
    fast: Node = head
    prev: Node = head
    while (fast is not None) and (fast.next != head):
        prev = slow
        slow = slow.next
        fast = fast.next.next
        if fast.next.next == head:
            break
    if is_len_even(fast, head):
        return prev
    else:
        return slow


def split_circular_list(head: Node) -> None:
    mid: Node = get_mid_node(head)
    head2: Node = mid.next
    mid.next = None
    mid.next = head
    # Make last node to point to head2
    temp: Node = head2
    while True:
        temp = temp.next
        if temp.next == head:
            break
    temp.next = head2
    print()
    util.display_circular_list(head)
    print()
    util.display_circular_list(head2)


def convert_to_circular_list(linked_list: LinkedList) -> None:
    current: Node = linked_list.head
    while current.next is not None:
        current = current.next
    current.next = linked_list.head


def create_circular_list():
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))
    linked_list.add_last(Node(6))
    linked_list.add_last(Node(8))
    convert_to_circular_list(linked_list)
    return linked_list.head


def main():
    head: Node = create_circular_list()
    util.display_circular_list(head)
    split_circular_list(head)


if __name__ == '__main__':
    main()
