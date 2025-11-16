from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


""""
https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/description/
"""
class Solution:
    count = 0;
    result = 0;


    def findTargetNode(self, root: Optional[TreeNode], cnt: int) -> int:
        self.inorder(root, cnt);
        return self.result;


    def inorder(self, root: Optional[TreeNode], cnt: int):
        if root is None:
            return
        self.inorder(root.right, cnt)
        if self.count >= cnt:
            return
        self.count += 1
        if self.count == cnt:
            self.result = root.val
            return
        self.inorder(root.left, cnt)
    