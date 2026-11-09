package livecoding5


class TreeNodeLetter(val letter: Char){
    val right: TreeNodeLetter? =null
    val left: TreeNodeLetter? =null
}

fun  findEquivalentPair(root: TreeNodeLetter?): Pair<TreeNodeLetter, TreeNodeLetter>?{
    if (root == null) {
        return null
    }
    val hm = mutableMapOf<String,TreeNodeLetter>()

    var a: TreeNodeLetter?=null
    var b: TreeNodeLetter?=null

    fun dfs(root: TreeNodeLetter?): Set<Char>{
        val hs = mutableSetOf<Char>()
        if (root == null) return hs
        hs.add(root.letter)
        if(root.right!=null) hs.addAll(dfs(root.right))
        if(root.left!=null) hs.addAll(dfs(root.left))
        val new = hs.sorted().joinToString("")
        if(hm.contains(new)) {
            a=hm[new]
            b=root
        }
        hm[new] = root
        return hs
    }
    dfs(root)
    return Pair(a!!,b!!)
}
