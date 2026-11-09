package trees_trainings

class TreeNode(val value: Int){
    var left: TreeNode?= null
    var right: TreeNode? = null
}
class BinarySearchTree(){
    var root: TreeNode? = null
    var curH=0
    fun insert(value: Int) {
        curH=0
        root=insertRec(root, value)
        print("${curH} ")
    }
    private fun insertRec(node:TreeNode?, value:Int): TreeNode{
        curH++
        if (node==null) return TreeNode(value)
        if(node.value<value) node.right = insertRec(node.right, value)
        if(node.value>value) node.left = insertRec(node.left, value)
        return node
    }
    fun getHeight():Int{
        return getHeightRec(root)
    }
    private fun  getHeightRec(node: TreeNode?):Int{
        if(node==null) return 0
        return(Math.max(getHeightRec(node.left),getHeightRec(node.right))+1)
    }
}

fun main(){
    val bs=BinarySearchTree()
    val s = readln().split(" ").map{it.toInt()}
    for(i in s){
        if(i!=0) bs.insert(i)
    }
    println(" ")
    println(bs.getHeight())
}