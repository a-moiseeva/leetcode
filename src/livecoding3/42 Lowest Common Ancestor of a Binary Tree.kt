package livecoding3

class TreeNode(
    var `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null,
    var parent: TreeNode
)



class Solution42 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var cur1= p
        var cur2 = q
        while(cur1!=cur2){
            if (cur1==root) cur1=cur2
            else cur1=cur1!!.parent

            if(cur2==root) cur2=cur1
            else cur2=cur2!!.parent
        }
        return cur1
    }
}