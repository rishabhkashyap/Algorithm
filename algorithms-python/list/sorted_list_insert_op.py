from typing import Optional

from list.linked_list import LinkedList, Node


def display(head: Node) -> None:
    if head is None:
        return
    temp: Node = head
    while temp is not None:
        print(temp.data, end="\t")
        temp = temp.next


def insert_in_ascending_order(head, node: Node) -> Optional[Node]:
    if head is None:
        return node
    if node.data <= head.data:
        node.next = head
        head = node
        return head

    temp: Node = head
    prev: Node = None
    while (temp is not None) and (temp.data < node.data):
        prev = temp
        temp = temp.next
    prev.next = node
    node.next = temp
    return head


def main() -> None:
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(7))
    linked_list.add_last(Node(10))
    linked_list.add_last(Node(25))
    linked_list.add_last(Node(32))
    linked_list.add_last(Node(35))
    linked_list.add_last(Node(48))
    linked_list.add_last(Node(50))
    head: Node = linked_list.head
    display(head)
    head = insert_in_ascending_order(head, Node(1))
    print()
    display(head)


if __name__ == '__main__':
    main()
