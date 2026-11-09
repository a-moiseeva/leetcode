    package livecoding2
class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
}

class Solution28 {
    fun isSymmetric(root: TreeNode?): Boolean {
        fun isMirror(left:TreeNode?, right:TreeNode?): Boolean{
            if((left==null) && (right==null)) return true
            if((left==null) || (right==null)) return false
            if(left!!.`val`!=right!!.`val`) return false
            return (isMirror(left.left, right.right)&&isMirror(left.right,right.left))
        }
        if(root==null) return true
        return isMirror(root.left, root.right)
    }
}