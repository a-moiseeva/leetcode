package livecoding3

class Solution60 {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if(root==null) return 0
        if(root.`val`< low) return rangeSumBST(root.right, low,high)
        if(root.`val`> high) return rangeSumBST(root.left, low,high)

        return root.`val`+ rangeSumBST(root.right, low,high)+rangeSumBST(root.left, low,high)

    }
}