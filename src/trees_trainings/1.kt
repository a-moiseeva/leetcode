package trees_trainings

class Node(val value: Int){
    var left: Node?= null
    var right: Node? = null
}
private class BinarySearch(){
    var root: Node? = null
    fun insert(value: Int){
        root=insertRec(root, value)
    }
    private fun insertRec(node:Node?, value:Int): Node{
        if (node==null) return Node(value)
        if(node.value<value) node.right = insertRec(node.right, value)
        if(node.value>value) node.left = insertRec(node.left, value)
        return node
    }
    fun getHeight():Int{
        return getHeightRec(root)
    }
    private fun  getHeightRec(node: Node?):Int{
        if(node==null) return 0
        return(Math.max(getHeightRec(node.left),getHeightRec(node.right))+1)
    }
}

fun main(){
    val bs=BinarySearch()
    val s = readln().split(" ").map{it.toInt()}
    for(i in s){
        if(i!=0) bs.insert(i)
    }
    println(bs.getHeight())
}