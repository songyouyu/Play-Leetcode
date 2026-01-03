# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

"""
https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
"""
class Solution:
    def __init__(self):
        self.dummyNode = TreeNode()
        self.curr = self.dummyNode


    def flatten(self, root: TreeNode) -> None:
        self.preorder(root)


    def preorder(self, root: TreeNode) -> None:
        if not root:
            return
        
        left = root.left
        right = root.right
        self.curr.right = root
        self.curr = root
        root.left = None
        
        self.preorder(left)
        self.preorder(right)
        