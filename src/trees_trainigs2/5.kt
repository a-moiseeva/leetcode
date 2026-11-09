package trees_trainigs2

class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class BS() {
    var root: TreeNode? = null
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: TreeNode?, value: Int): TreeNode {
        if (node == null) return TreeNode(value)
        if (node.value < value) node.right = insertRec(node.right, value)
        if (node.value > value) node.left = insertRec(node.left, value)
        return node
    }

    fun getHeight(): Int {
        return getHeightRec(root)
    }

    private fun getHeightRec(node: TreeNode?): Int {
        if (node == null) return 0
        return (Math.max(getHeightRec(node.left), getHeightRec(node.right)) + 1)
    }

    fun obhodLeaf() {
        obhodLeafRec(root!!)
    }

    private fun obhodLeafRec(node: TreeNode) {
        if (node.right == null && node.left == null) {
            println(node.value)
            return
        }
        if (node.left != null) {
            obhodLeafRec(node.left!!)
        }
        if (node.right != null) {
            obhodLeafRec(node.right!!)
        }
    }
}

fun main() {
    val bs = BS()
    val s = readln().split(" ").map { it.toInt() }
    for (i in s) {
        if (i != 0) bs.insert(i)
    }
    println(bs.obhodLeaf())
}