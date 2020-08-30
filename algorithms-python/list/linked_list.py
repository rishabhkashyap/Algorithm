from typing import Optional


class Node:
    __slots__ = ["_data", "_next"]

    def __init__(self, data):
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
    __slots__ = ["_head", "_count"]

    def __init__(self):
        self._head: Optional[Node] = None
        self._count: int = 0

    def add_first(self, node: Node):
        if self._head is None:
            self._head = node
            return
        node.next = self._head
        self._head = node

    def display(self):
        temp: Node = self._head
        while temp is not None:
            print(temp.data, end="\t",)
            temp = temp.next


if __name__ == '__main__':
    node1: Node = Node(1)
    node2: Node = Node(2)
    node3: Node = Node(3)
    linked_list: LinkedList = LinkedList()
    linked_list.add_first(node1)
    linked_list.add_first(node2)
    linked_list.add_first(node3)
    linked_list.display()
