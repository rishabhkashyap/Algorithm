from typing import Optional


class Node:
    __slots__ = ["_data", "_next"]

    def __init__(self, data=0):
        self._data: int = data
        self._next: Optional[Node] = None

    @property
    def data(self):
        return self._data

    @data.setter
    def data(self, data: int):
        self._data = data

    @property
    def next(self):
        return self._next

    @next.setter
    def next(self, node):
        self._next = node


class LinkedList:
    __slots__ = ["_head", "_tail", "_count"]

    def __init__(self):
        self._head: Optional[Node] = None
        self._tail: Optional[Node] = None
        self._count: int = 0

    @property
    def head(self) -> Optional[Node]:
        return self._head

    @property
    def tail(self) -> Optional[Node]:
        return self._tail

    def add_first(self, node: Node):
        if self._head is None:
            self._head = node
            self._tail = node
            return
        node.next = self._head
        self._head = node

    def add_last(self, node: Node):
        if self._head is None:
            self._head = node
            self._tail = node
            return
        temp: Node = self._head
        while temp.next is not None:
            temp = temp.next
        temp.next = node
        self._tail = node

    def search(self, element: int) -> bool:
        temp: Node = self._head
        while temp is not None:
            if temp.data == element:
                return True
            temp = temp.next
        return False

    def display(self):
        temp: Node = self._head
        while temp is not None:
            print(temp.data, end="\t", )
            temp = temp.next


if __name__ == '__main__':
    node1: Node = Node(1)
    node2: Node = Node(2)
    node3: Node = Node(3)
    linked_list1: LinkedList = LinkedList()
    print("Inserting elements at beginning")
    linked_list1.add_first(node1)
    linked_list1.add_first(node2)
    linked_list1.add_first(node3)
    linked_list1.display()
    print("\n*****************************************************")
    linked_list2: LinkedList = LinkedList()
    node1.next = None
    node2.next = None
    node3.next = None
    print("Inserting element at end")
    linked_list2.add_last(node1)
    linked_list2.add_last(node2)
    linked_list2.add_last(node3)
    linked_list2.display()
    print(f"\nList contains element 1 = {linked_list2.search(1)}")
    print(f"List contains element 8 = {linked_list2.search(8)}")
