package `2_base`


fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val m = mutableMapOf<Int, Int>()
    for (i in a) {
        m[i] = m.getOrDefault(i, 0) + 1
    }
    //println(m)
    val sortedElements = m.entries
        .sortedWith(compareByDescending<Map.Entry<Int,Int>>{it.value }.thenBy { it.key }).take(3)
    println(sortedElements.sortedBy { it.key }.map{it-> it.key}.joinToString(" "))
}