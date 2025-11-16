from typing import Optional, Deque
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


"""
https://leetcode.cn/problems/maximum-depth-of-binary-tree/submissions/678263533/
"""
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        maxDepth = 0
        if root is None:
            return maxDepth

        q = deque([root])
        q.append(root)

        while q:
            maxDepth += 1
            for _ in range(len(q)):
                tn = q.popleft()
                if tn.left:
                    q.append(tn.left)
                if tn.right:
                    q.append(tn.right)
            
        return maxDepth