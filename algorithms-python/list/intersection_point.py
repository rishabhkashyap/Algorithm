from typing import Optional, List

from list.linked_list import LinkedList, Node


def convert_to_stack(head: Node) -> List[Node]:
    stack: List[Node] = list()
    temp: Node = head
    while temp is not None:
        stack.append(temp)
        temp = temp.next

    return stack


# Use stack to find intersection point of linked lists
def find_intersection1(head1: Node, head2: Node) -> Node:
    if (head1 is None) or (head2 is None):
        raise ValueError("One of the 2 passes head nodes is none")
    stack1: List[Node] = convert_to_stack(head=head1)
    stack2: List[Node] = convert_to_stack(head=head2)
    intersection_node: Optional[Node] = None
    while stack1 and stack2:
        if stack1[-1] == stack2[-1]:
            intersection_node = stack1.pop()
            stack2.pop()
        else:
            break
    return intersection_node


def count_nodes(head: Node) -> int:
    temp: Node = head
    count: int = 0
    while temp is not None:
        count += 1
        temp = temp.next
    return count


def move_head(head: Node, delta: int) -> Node:
    temp: Node = head
    count: int = 0
    while count < delta:
        temp = temp.next
        count += 1
    return temp


# Move head of longer linked list by len1-len2 and find common node
def find_intersection2(head1: Node, head2: Node) -> Node:
    if (head1 is None) or (head2 is None):
        raise ValueError("One of the 2 passes head nodes is none")
    node_count1: int = count_nodes(head1)
    node_count2: int = count_nodes(head2)
    temp_head1: Node = head1
    temp_head2: Node = head2
    if node_count1 > node_count2:
        temp_head1 = move_head(head1, node_count1 - node_count2)
    elif node_count2 > node_count1:
        temp_head2 = move_head(head2, node_count2 - node_count1)

    while temp_head1 != temp_head2:
        temp_head1 = temp_head1.next
        temp_head2 = temp_head2.next
    return temp_head1


def main():
    linked_list1: LinkedList = LinkedList()
    linked_list2: LinkedList = LinkedList()
    linked_list_common: LinkedList = LinkedList()
    linked_list1.add_last(Node(3))
    linked_list1.add_last(Node(6))
    linked_list1.add_last(Node(9))
    linked_list1.add_last(Node(35))
    linked_list2.add_last(Node(17))
    linked_list2.add_last(Node(10))
    linked_list_common.add_last(Node(56))
    linked_list_common.add_last(Node(15))
    linked_list_common.add_last(Node(30))
    head1: Node = linked_list1.head
    head2: Node = linked_list2.head
    head_common: Node = linked_list_common.head
    tail1: Node = linked_list1.tail
    tail2: Node = linked_list2.tail
    tail1.next = head_common
    tail2.next = head_common
    # intersection_node: Node = find_intersection1(head1, head2)
    intersection_node: Node = find_intersection2(head1, head2)
    print(f"Intersection point of both list = {intersection_node.data}")


if __name__ == '__main__':
    main()
