# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result: List[int] = []
        self._inorerTraversal(root, result)
        return result
    

    def _inorerTraversal(self, node: Optional[TreeNode], result: List[int]) -> None:
        if not node:
            return
        
        self._inorerTraversal(node.left, result)
        result.append(node.val)
        self._inorerTraversal(node.right, result)