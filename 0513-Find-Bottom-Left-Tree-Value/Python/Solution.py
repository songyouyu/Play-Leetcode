from typing import Optional, Deque
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        result: int = -1

        q: Deque[TreeNode] = deque()
        q.append(root)

        while q:
            size: int = len(q)
            if size:
                result = q[0].val

            for _i in range(size):
                tn = q.popleft()
                if tn.left:
                    q.append(tn.left)
                if tn.right:
                    q.append(tn.right)

        return result
