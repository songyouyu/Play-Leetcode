from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


"""
https://leetcode.cn/problems/symmetric-tree/
"""
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isSymmetricHelper(root.left, root.right)

    def isSymmetricHelper(self, left_node: Optional[TreeNode], right_node: Optional[TreeNode]) -> bool:
        if left_node is None and right_node is None:
            return True
        if left_node is None or right_node is None:
            return False
        if left_node.val != right_node.val:
            return False

        return self.isSymmetricHelper(left_node.left, right_node.right) and self.isSymmetricHelper(left_node.right, right_node.left)
        