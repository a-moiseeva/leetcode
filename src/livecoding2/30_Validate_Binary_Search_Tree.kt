package livecoding2
/*class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }*/
class Solution30 {
    fun isValidBST(root: TreeNode?): Boolean {
        fun isOkay(root: TreeNode?, max:Int?,min: Int?): Boolean{
            if(root==null) return true
            if(max!=null&& root.`val`>=max || min!=null&& root.`val`<=min) return false
            return(isOkay(root!!.left, root.`val`, min )&&isOkay(root!!.right, max, root.`val`))
        }
        return isOkay(root,null,null)

    }
}