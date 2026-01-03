# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

"""
https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
"""
class Solution:
    res: TreeNode = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (root.val - p.val) * (root.val - q.val) <= 0:
            self.res = root
        elif root.val > p.val and root.val > q.val:
            self.lowestCommonAncestor(root.left, p, q)
        else:
            self.lowestCommonAncestor(root.right, p, q)

        return self.res

