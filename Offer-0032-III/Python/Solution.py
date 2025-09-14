from typing import Optional, List, Deque
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def decorateRecord(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        
        result: List[List[int]] = []
        q: Deque[TreeNode] = deque()
        q.append(root)
        reverse = False

        while q:
            size: int = len(q)
            sub_list: List[int] = []
            for _i in range(size):
                tn = q.popleft()
                sub_list.append(tn.val)
                if tn.left:
                    q.append(tn.left)
                if tn.right:
                    q.append(tn.right)

            if not reverse:
                reverse = True
            else:
                reverse = False
                sub_list.reverse()

            result.append(sub_list)

        return result

