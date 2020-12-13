from typing import Optional

from list.linked_list import Node, LinkedList


def display(head: Node) -> None:
    if head is None:
        return
    temp: Node = head
    while temp is not None:
        print(temp.data, end="\t")
        temp = temp.next


def is_list_even_len(head: Node) -> bool:
    if head is None:
        raise ValueError("Head of node is null or has invalid")
    fast_node: Node = head
    while (fast_node is not None) and (fast_node.next is not None):
        fast_node = fast_node.next.next
    result: bool = True if fast_node is None else False
    return result


def main():
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))


    linked_list.add_last(Node(6))
    head: Node = linked_list.head
    print(f"Length of list is even = {is_list_even_len(head=head)}")


if __name__ == '__main__':
    main()
