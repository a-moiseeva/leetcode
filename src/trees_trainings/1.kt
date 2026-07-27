package trees_trainings

class Node(val value: Int){
    var left: Node? = null
    var right: Node? = null
}

class BinarySearchTree {
    private var root: Node? = null
    private var height = 0
    fun insert(value: Int) {
        root = insertRec(root,value)
    }
    fun insertRec(node: Node?, value: Int) : Node{
        if (node==null) return Node(value)
        if (value<node.value) {
            node.left=  insertRec(node.left ,value)
        }
        if (value>node.value) {
            node.right = insertRec(node.right, value)
        }
        return node
    }
    fun height(): Int {
        return heightRec(root)
    }
    private fun heightRec(node: Node?): Int {
        if (node == null) {
            return 0
        }
        val leftHeight = heightRec(node.left)
        val rightHeight = heightRec(node.right)
        return Math.max(leftHeight, rightHeight) + 1
    }

}

fun main() {
    val l  = readln().split(" ").map { it.toInt() }
    val T = BinarySearchTree()
    for(i in l){
        T.insert(i)
    }
    println(T.height())
}