from typing import Optional, List, Deque
from collections import deque


# Definition for a Node.
class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if root is None:
            return []
        
        result: List[List[int]] = []
        q: Deque[Node] = deque()
        q.append(root)

        while q:
            size: int = len(q)
            sub_list: List[int] = []
            for _i in range(size):
                tn = q.popleft()
                sub_list.append(tn.val)
                for n in tn.children:
                    q.append(n)
            result.append(sub_list)

        return result