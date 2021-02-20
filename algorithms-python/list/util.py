from list.linked_list import Node


def display(head: Node) -> None:
    if head is None:
        return
    temp: Node = head
    while temp is not None:
        print(temp.data, end="\t")
        temp = temp.next


def display_circular_list(head: Node) -> None:
    if head is None:
        return
    temp: Node = head
    while True:
        print(temp.data, end="\t")
        temp = temp.next
        if temp == head:
            break
