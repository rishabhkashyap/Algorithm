from typing import Optional

from list import util
from list.linked_list import LinkedList, Node


def size(head: Node):
    current: Node = head
    count: int = 0
    while current is not None:
        count += 1
        current = current.next
    return count


def rotate_nodes_back_to_front1(head: Node, k: int):
    if head is None:
        raise ValueError("Node cannot be none")
    length: int = size(head)
    remaining_nodes: int = length - k
    i: int = 0
    current: Optional[Node] = head
    tail: Optional[Node] = None
    # separate list at kth node from end
    while i < remaining_nodes:
        tail = current
        current = current.next
        i += 1
    tail.next = None
    # List is divided into remaining_nodes and k nodes
    # Consider kth node from head move till end and make last node point to  actual head of list
    temp: Node = current
    while temp.next is not None:
        temp = temp.next
    temp.next = head
    return current


# Moves k nodes from back to front and return new head
'''
    1. Count number of nodes in list
    2. move temp node(initially point to head) to count-k nodes
    3. Convert list to circular list and return temp as new head
'''


def rotate_nodes_back_to_front2(head: Node, k: int):
    if head is None:
        raise ValueError("Node cannot be none")
    count: int = 1
    tail: Node = head
    # get count of nodes in list
    while tail.next is not None:
        tail = tail.next
        count += 1
    if count - k == 0:
        return head
    if k > count:
        k %= count
    previous: Optional[Node] = None
    temp = head
    i: int = 0
    while i < (count - k):
        previous = temp
        temp = temp.next
        i += 1
    tail.next = head
    previous.next = None
    return temp


# Turn linked list to circular list
'''
    Similar to previous approach but list is converted to circular list before moving 
    temp(initially pointing to original head)to count-k nodes
    1. Count number of nodes in list
    2. Convert list to circular list and return temp as new head 
    3. move temp node(initially point to head) to count-k nodes 
'''


def rotate_nodes_back_to_front3(head: Node, k: int):
    if head is None:
        raise ValueError("Node cannot be none")
    count: int = 1
    tail: Node = head
    # get count of nodes in list
    while tail.next is not None:
        tail = tail.next
        count += 1
    if count - k == 0:
        return head
    tail.next = head
    if k > count:
        k %= count
    previous: Optional[Node] = None
    temp = head
    i: int = 0
    while i < (count - k):
        previous = temp
        temp = temp.next
        i += 1
    previous.next = None
    return temp


def main():
    linked_list: LinkedList = LinkedList()
    linked_list.add_last(Node(1))
    linked_list.add_last(Node(2))
    linked_list.add_last(Node(3))
    linked_list.add_last(Node(4))
    linked_list.add_last(Node(5))
    # linked_list.add_last(Node(6))
    # linked_list.add_last(Node(7))
    # linked_list.add_last(Node(8))
    print("Original list")
    util.display(linked_list.head)
    # head: Node = rotate_nodes_back_to_front(linked_list.head, 2)
    # head: Node = rotate_nodes_back_to_front2(linked_list.head, 5)
    head: Node = rotate_nodes_back_to_front3(linked_list.head, 3)
    print("\n\nList after rotating k nodes")
    util.display(head)


if __name__ == '__main__':
    main()
