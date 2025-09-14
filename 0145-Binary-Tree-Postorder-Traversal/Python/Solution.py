from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result: List[int] = []
        self._postorderTraversal(root, result)
        return result
    

    def _postorderTraversal(self, node: Optional[TreeNode], result: List[int]):
        if node is None:
            return
        self._postorderTraversal(node.left, result)
        self._postorderTraversal(node.right, result)
        result.append(node.val)
    