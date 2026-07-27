package `2_base`

fun main() {
    val n=readln().toInt()
    var a = readln().split(" ").map { it.toInt() }
    var b = mutableListOf<Int>(a[0])
    var curMin = a[0]
    for (i in 1..n - 1) {
        if (a[i]<curMin){
            curMin = a[i]
        }
        b.add(curMin)
    }
    println(b.joinToString(" "))
}
