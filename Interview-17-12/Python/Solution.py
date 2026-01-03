# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.dummyNode = TreeNode()
        self.curr = self.dummyNode

    def convertBiNode(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.inorder(root)
        return self.dummyNode.right

    def inorder(self, root: TreeNode):
        if root is None:
            return
        self.inorder(root.left)

        self.curr.right = root
        self.curr = root
        root.left = None

        self.inorder(root.right)
