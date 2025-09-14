from typing import List, Optional


# Definition for a Node.
class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []

        result: List[int] = []
        stack: List[Node] = []
        stack.append(root)
        new_stack: List[Node] = []

        while stack:
            node = stack.pop()
            new_stack.append(node)
            for n in node.children:
                stack.append(n)
            
        while new_stack:
            result.append(new_stack.pop().val)    
        return result
