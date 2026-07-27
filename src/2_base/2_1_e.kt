package `2_base`

fun main() {

    val n = readln().toInt()
    val a = readln().split(" ").map { it -> it.toInt() }

    val b = mutableListOf<Int>()
    b.add(a[0])
    for (i in 1..n - 2) {
        if (!((a[i] < a[i - 1]) &&( a[i] < a[i + 1]))) {
            b.add(a[i])
        }
    }
    b.add(a[n-1])
    println(b.size)
    print(b.joinToString(" "))
}