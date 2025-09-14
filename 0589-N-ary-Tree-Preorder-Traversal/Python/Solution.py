from typing import List, Optional


# Definition for a Node.
class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []

        reuslt: List[int] = []
        stack: List[Node] = []
        stack.append(root)

        while stack:
            node = stack.pop()
            reuslt.append(node.val)
            for n in reversed(node.children):
                stack.append(n)

        return reuslt