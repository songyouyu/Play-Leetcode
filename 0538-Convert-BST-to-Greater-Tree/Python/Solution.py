from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


"""
https://leetcode.cn/problems/convert-bst-to-greater-tree/description/
"""
class Solution:
    sum = 0;

    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.inorder(root)
        return root

    def inorder(self, root: Optional[TreeNode]):
        if root is None:
            return
        self.inorder(root.right)
        self.sum += root.val
        root.val = self.sum
        self.inorder(root.left)