from list.linked_list import LinkedList, Node


def display(head: Node) -> None:
    if head is None:
        return
    temp: Node = head
    while temp is not None:
        print(temp.data, end="\t")
        temp = temp.next


def reverse_iterate(head: Node) -> None:
    if head is None:
        return
    reverse_iterate(head.next)
    print(head.data, end="\t")


def main():
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))
    head: Node = linked_list.head
    print("Original list")
    display(head=head)
    print("\n\nReversed list")
    reverse_iterate(head=head)


if __name__ == '__main__':
    main()
