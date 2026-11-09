package trees_trainings
class Nodde(val value: Int){
    var left: Nodde?= null
    var right: Nodde? = null
}
class BST(){
    var root: Nodde? = null
    fun insert(value: Int) {

        root=insertRec(root, value)
    }
    private fun insertRec(node:Nodde?, value:Int): Nodde{
        if (node==null) return Nodde(value)
        if(node.value<value) node.right = insertRec(node.right, value)
        if(node.value>value) node.left = insertRec(node.left, value)
        return node
    }
    fun getHeight():Int{
        return getHeightRec(root)
    }
    private fun  getHeightRec(node: Nodde?):Int{
        if(node==null) return 0
        return(Math.max(getHeightRec(node.left),getHeightRec(node.right))+1)
    }
    fun findSecondMax():Int{
        val maxNode = findMax(root)
        val parentOfMaxInt = findParentOfMax(root,maxNode)
        val maxSonOfMaxNode = if (maxNode!!.left==null) -1 else findMax(maxNode.left)!!.value
        return Math.max(parentOfMaxInt, maxSonOfMaxNode)
    }

    fun findMax(node:Nodde?) : Nodde?{
        if(node==null) return null
        if (node.right==null) return node
        return findMax(node.right)
    }
    fun findParentOfMax(node:Nodde?, maxNode:Nodde?):Int{
        if (node==null) return -1
        if(maxNode==null) return -1
        if(node.right==maxNode) return node.value
        return findParentOfMax(node.right!!,maxNode)
    }
}

fun main(){
    val bs=BST()
    val s = readln().split(" ").map{it.toInt()}
    for(i in s){
        if(i!=0) bs.insert(i)
    }
    println(bs.findSecondMax())
}
