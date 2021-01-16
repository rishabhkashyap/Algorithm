from typing import Optional

from list import util
from list.linked_list import LinkedList, Node


def merge_lists_iteration(head1: Node, head2: Node) -> Optional[Node]:
    if head1 is None:
        return head2
    if head2 is None:
        return head1
    if (head1 is None) and (head2 is None):
        return None
    temp1: Node = head1
    temp2: Node = head2
    merged_head: Node = Node()
    merged_tail: Node = merged_head
    while (temp1 is not None) and (temp2 is not None):
        if temp1.data < temp2.data:
            merged_tail.next = temp1
            temp1 = temp1.next
        else:
            merged_tail.next = temp2
            temp2 = temp2.next
        merged_tail = merged_tail.next
    while temp1 is not None:
        merged_tail.next = temp1
        temp1 = temp1.next
        merged_tail = merged_tail.next
    while temp2 is not None:
        merged_tail.next = temp2
        temp2 = temp2.next
        merged_tail = merged_tail.next
    return merged_head.next


def merge_lists_recursive(head1: Node, head2: Node) -> Optional[Node]:
    if head1 is None:
        return head2
    if head2 is None:
        return head1
    if (head1 is None) and (head2 is None):
        return None
    if head1.data < head2.data:
        temp = head1
        temp.next = merge_lists_recursive(head1.next, head2)
    else:
        temp = head2
        temp.next = merge_lists_recursive(head1, head2.next)
    return temp


def main():
    linked_list1: LinkedList = LinkedList()
    linked_list2: LinkedList = LinkedList()
    linked_list1.add_last(Node(1))
    linked_list1.add_last(Node(7))
    linked_list1.add_last(Node(10))
    linked_list1.add_last(Node(15))
    linked_list1.add_last(Node(29))
    linked_list1.add_last(Node(80))

    linked_list2.add_last(Node(2))
    linked_list2.add_last(Node(4))
    linked_list2.add_last(Node(6))
    linked_list2.add_last(Node(9))
    linked_list2.add_last(Node(35))
    linked_list2.add_last(Node(50))
    linked_list2.add_last(Node(70))
    linked_list2.add_last(Node(79))

    # linked_list1.add_last(Node(5))
    # linked_list1.add_last(Node(7))
    # linked_list1.add_last(Node(9))
    #
    # linked_list2.add_last(Node(4))
    # linked_list2.add_last(Node(6))
    # linked_list2.add_last(Node(8))

    print("List 1")
    linked_list1.display()
    print("\nList 2")
    linked_list2.display()
    # head = merge_lists_iteration(linked_list1.head, linked_list2.head)
    head = merge_lists_recursive(linked_list1.head, linked_list2.head)
    print("\nMerged list")
    util.display(head)


if __name__ == '__main__':
    main()
