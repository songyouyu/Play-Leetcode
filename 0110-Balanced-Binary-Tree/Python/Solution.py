from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.height(root) >= 0


    def height(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        lelft_height = self.height(root.left)
        right_height = self.height(root.right)
        if lelft_height >= 0 and right_height >= 0 and abs(lelft_height - right_height) <= 1:
            return max(lelft_height, right_height) + 1
        else:
            return -1