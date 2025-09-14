from typing import Optional, List
import queue

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def decorateRecord(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        
        result: List[int] = []
        q: queue.Queue[TreeNode] = queue.Queue()
        q.put(root)
        while not q.empty():
            tn = q.get()
            result.append(tn.val)
            if tn.left:
                q.put(tn.left)
            if tn.right:
                q.put(tn.right)

        return result        

