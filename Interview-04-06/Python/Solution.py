# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


""""
https://leetcode.cn/problems/successor-lcci/submissions/678469005/
"""
class Solution:
    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> TreeNode:
        self.list = []
        self.inorder(root)
        lenght = len(self.list)
        for i, node in enumerate(self.list):
            if node.val == p.val:
                if i + 1 < len(self.list):
                    return self.list[i + 1]
                else:
                    return None


    def inorder(self, root: TreeNode):
        if root is None:
            return
        self.inorder(root.left)
        self.list.append(root)
        self.inorder(root.right)