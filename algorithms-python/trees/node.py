from __future__ import annotations
from typing import Optional

class Node:
    __slots__ = ["_data", "_left", "_right"]

    def __init__(self, data: int = 0):
        self._data: int = data
        self._left: Optional[Node] = None
        self._right: Optional[Node] = None

    @property
    def data(self) -> int:
        return self._data

    @data.setter
    def data(self, data: int):
        self._data = data

    @property
    def left(self) -> Optional[Node]:
        return self._left

    @left.setter
    def left(self, left: Optional[Node]):
        self._left = left

    @property
    def right(self):
        return self._right

    @right.setter
    def right(self, right: Optional[Node]):
        self._right = right
