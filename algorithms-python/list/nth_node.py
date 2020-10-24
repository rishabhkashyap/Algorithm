from typing import Optional

from list.linked_list import Node, LinkedList


def find_node_from_end(node: Node, n: int) -> Optional[Node]:
    if node is None:
        return None
    i: int = 0
    temp: Node = node
    while i < n - 1:
        temp = temp.next
        i += 1
    nth_node: Optional[Node] = None
    while temp is not None:
        if nth_node is not None:
            nth_node = nth_node.next
        else:
            nth_node = node
        temp = temp.next
    return nth_node


def display(node: Node):
    if node is None:
        return
    temp: Node = node
    while temp is not None:
        print(temp.data, end="\t")
        temp = temp.next


if __name__ == '__main__':
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))
    linked_list.add_last(Node(6))
    linked_list.add_last(Node(7))
    head: Node = linked_list.head
    display(head)
    location: int = 2
    print(f"\n{location} th node from end = {find_node_from_end(head, location).data}")
