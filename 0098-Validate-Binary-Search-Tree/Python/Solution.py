from typing import Optional
import sys


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


"""
https://leetcode.cn/problems/validate-binary-search-tree/
"""        
class Solution:
    last = -sys.maxsize - 1

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        l = self.isValidBST(root.left)
        if self.last >= root.val:
            return False
        self.last = root.val
        r = self.isValidBST(root.right)

        return l and r
        