from typing import Optional, List, Deque
from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        
        result: List[List[int]] = []
        q: Deque[TreeNode] = deque()
        q.append(root)

        while q:
            size: int = len(q)
            sub_list: List[int] = []
            for _i in range(size):
                tn = q.popleft()
                sub_list.append(tn.val)
                if tn.left:
                    q.append(tn.left)
                if tn.right:
                    q.append(tn.right)

            result.append(sub_list)

        return result
    

    def levelOrder_1(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        
        result: List[List[int]] = []
        self.dfs(root, 0, result)

        return result
    

    def dfs(self, root: Optional[TreeNode], level: int, result: List[List[int]]) -> None:
        if root is None:
            return
        
        if level > len(result) - 1:
            sub_list: List[int] = []
            result.append(sub_list)

        result[level].append(root.val)    
        self.dfs(root.left, level + 1, result)
        self.dfs(root.right, level + 1, result)
            
            

            

            
