from list.linked_list import LinkedList, Node


def convert_to_circular_list(node: Node) -> None:
    if node is None:
        return
    temp: Node = node
    while temp.next is not None:
        temp = temp.next

    temp.next = node


def cycle_exist(node: Node) -> bool:
    if node is None:
        return False
    slow_ptr: Node = node
    fast_ptr: Node = node
    while (fast_ptr is not None) and (fast_ptr.next is not None):
        fast_ptr = fast_ptr.next.next
        slow_ptr = slow_ptr.next
        if fast_ptr == slow_ptr:
            return True
    return False


if __name__ == '__main__':
    list1: LinkedList = LinkedList()
    list1.add_last(Node(1))
    list1.add_last(Node(2))
    list1.add_last(Node(3))
    list1.add_last(Node(4))
    list1.add_last(Node(5))
    head: Node = list1.head
    # convert_to_circular_list(head)
    print(f" List has cycle = {cycle_exist(head)}")
