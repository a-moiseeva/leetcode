package `2_base`


fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    var a = readln().split(" ").map { it.toInt() }
    var b = mutableMapOf<Int, Int>()
    for (i in 0..n - 1) {
        if (!b.contains(a[i])) {
            b[ a[i] ] = i+1
        }
    }
    repeat(q) {
        val c = readln().toInt()
        println(b.getOrDefault(c,-1))
    }
    return
}




