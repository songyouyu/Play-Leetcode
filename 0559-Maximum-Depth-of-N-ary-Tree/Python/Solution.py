from collections import deque
from typing import List, Optional


# Definition for a Node.
class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children


"""
https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
"""
class Solution:
    def maxDepth(self, root: 'Node') -> int:
        depth = 0
        if root is None:
            return depth

        q = deque([root])
        q.append(root)

        while q:
            depth += 1
            for _ in range(len(q)):
                tn = q.popleft()
                for n in tn.children:
                    q.append(n)
            
        return depth
